package com.yorix.hillel.java_elementary.task41.parser;

import com.yorix.hillel.java_elementary.task41.Currency;
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
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String element = new String(ch, start, length);
                if (r030) {
                    currencies.get(currencies.size() - 1).setR030(element);
                    r030 = false;
                }
                if (txt) {
                    currencies.get(currencies.size() - 1).setTxt(element);
                    txt = false;
                }
                if (rate) {
                    currencies.get(currencies.size() - 1).setRate(Double.parseDouble(element));
                    rate = false;
                }
                if (cc) {
                    currencies.get(currencies.size() - 1).setCc(element);
                    cc = false;
                }
                if (exchangedate) {
                    currencies.get(currencies.size() - 1).setExchangedate(LocalDate.parse(element, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
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

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void showRate(String requiredCurrency) {
        currencies.stream()
                .filter(currency -> currency.getTxt().toLowerCase().contains(requiredCurrency.toLowerCase()))
                .map(currency -> currency.getTxt()
                        + ". Курс на "
                        + currency.getExchangedate().format(DateTimeFormatter.ofPattern("dd.MM.yy"))
                        + " - "
                        + currency.getRate())
                .forEach(System.out::println);
    }
}
