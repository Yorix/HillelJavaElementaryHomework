package com.yorix.hillel.java_elementary.task41;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExchangeParser {
    private final String path = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";
    private List<Currency> currencies = new ArrayList<>();

    public void parse() {
        DefaultHandler handler = new DefaultHandler() {
            private boolean r030;
            private boolean txt;
            private boolean rate;
            private boolean cc;
            private boolean exchangedate;
            int count = -1;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("exchange")) return;
                switch (qName) {
                    case "r030":
                        r030 = true;
                        break;
                    case "txt":
                        txt = true;
                        break;
                    case "rate":
                        rate = true;
                        break;
                    case "cc":
                        cc = true;
                        break;
                    case "exchangedate":
                        exchangedate = true;
                        break;
                    default:
                        currencies.add(new Currency());
                        count++;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String element = new String(ch, start, length);
                if (r030) {
                    currencies.get(count).setR030(element);
                    r030 = false;
                }
                if (txt) {
                    currencies.get(count).setTxt(element);
                    txt = false;
                }
                if (rate) {
                    currencies.get(count).setRate(Double.parseDouble(element));
                    rate = false;
                }
                if (cc) {
                    currencies.get(count).setCc(element);
                    cc = false;
                }
                if (exchangedate) {
                    currencies.get(count).setExchangedate(LocalDate.parse(element, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                    exchangedate = false;
                }
            }
        };

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            parser.parse(path, handler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String requiredCurrency = "долар сша";

        ExchangeParser exchangeParser = new ExchangeParser();
        exchangeParser.parse();
        exchangeParser.currencies.stream()
                .filter(currency -> currency.getTxt().equalsIgnoreCase(requiredCurrency))
                .map(currency -> currency.getTxt()
                        + ". Курс на "
                        + currency.getExchangedate().format(DateTimeFormatter.ofPattern("dd.MM.yy"))
                        + ": 1 USD = "
                        + currency.getRate()
                        + " UAH")
                .forEach(System.out::println);
    }
}
