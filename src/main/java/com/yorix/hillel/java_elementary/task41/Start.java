package com.yorix.hillel.java_elementary.task41;

import com.yorix.hillel.java_elementary.task41.dao.interfaces.Controller;
import com.yorix.hillel.java_elementary.task41.dao.logic.CurrencyDbController;
import com.yorix.hillel.java_elementary.task41.parser.ExchangeParser;

public class Start {
    public static void main(String[] args) {
        Controller<Currency, String> currencyController = new CurrencyDbController();
        ExchangeParser exchangeParser = new ExchangeParser();

        exchangeParser.parse();

        currencyController.createAll(exchangeParser.getCurrencies());
        System.out.println(currencyController.get("сша"));
        currencyController.delete("долар сша");
        System.out.println(currencyController.get("сша"));
    }
}
