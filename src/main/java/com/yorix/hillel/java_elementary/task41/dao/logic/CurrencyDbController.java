package com.yorix.hillel.java_elementary.task41.dao.logic;

import com.yorix.hillel.java_elementary.task41.Currency;
import com.yorix.hillel.java_elementary.task41.dao.interfaces.Controller;

import java.sql.*;
import java.util.Collection;

public class CurrencyDbController implements Controller<Currency, String> {
    private Connection connection;

    public CurrencyDbController() {
        try {
            String createTableSQL = "create table if not exists `currency` (" +
                    "`r030` varchar(5) primary key," +
                    " `txt` varchar(50)," +
                    " `rate` double(16, 10)," +
                    " `cc` varchar(3)," +
                    " `exchangedate` date)";
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC",
                    "user", "password");
            Statement statement = connection.createStatement();
            statement.execute("create schema if not exists `exchange`");
            statement.execute("use `exchange`");
            statement.execute(createTableSQL);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Currency currency) {
        String sql = "insert into currency (r030, txt, rate, cc, exchangedate) values (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currency.getR030());
            statement.setString(2, currency.getTxt());
            statement.setDouble(3, currency.getRate());
            statement.setString(4, currency.getCc());
            statement.setDate(5, Date.valueOf(currency.getExchangedate()));
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            update(currency);
            System.out.println("update: " + currency.getTxt());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createAll(Collection<Currency> list) {
        list.forEach(this::create);
    }

    @Override
    public Currency get(String txt) {
        Currency currency = null;
        String sql = "select * from currency where currency.txt like '%" + txt + "%';";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            currency = new Currency();
            while (resultSet.next()) {
                currency.setR030(resultSet.getString("r030"));
                currency.setTxt(resultSet.getString("txt"));
                currency.setRate(resultSet.getDouble("rate"));
                currency.setCc(resultSet.getString("cc"));
                currency.setExchangedate(resultSet.getDate("exchangedate").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currency;
    }

    @Override
    public void update(Currency currency) {
        String sql = "update `currency`\n" +
                " set `r030` = ?, `txt` = ?, `rate` = ?, `cc` = ?, `exchangedate` = ?\n" +
                " where `r030` = " + currency.getR030();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currency.getR030());
            statement.setString(2, currency.getTxt());
            statement.setDouble(3, currency.getRate());
            statement.setString(4, currency.getCc());
            statement.setDate(5, Date.valueOf(currency.getExchangedate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String txt) {
        String sql = "delete from `currency` where txt = '" + txt + "'";
        try (Statement statement = connection.prepareStatement(sql)) {
            int complete = statement.executeUpdate(sql);
            if (complete == 1) {
                System.out.println("\n" + txt + " deleted!");
            } else {
                System.err.println("\n" + txt + " doesn't exists!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
