package com.yorix.hillel.java_elementary.task40;

import java.sql.*;

public class Db {
    private static Connection connection;

    public static void main(String[] args) {
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/auto" +
                                    "?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC",
                            "user", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        showModelsByBrand("Mitsubishi");
        showCarsCheaperThan(20_000);
        showModelsByCountry("Germany");
        showTheMostExpensiveCar();
        showCheapestCar();

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showCheapestCar() {
        showCarByMaxOrMinPrice("min");
    }

    private static void showTheMostExpensiveCar() {
        showCarByMaxOrMinPrice("max");
    }

    private static void showCarByMaxOrMinPrice(String value) {
        String sql = "select * from model" +
                " join brand on model.brand_id = brand.id" +
                " join gear_box on model.gear_box_type_id = gear_box.id" +
                " join country on model.country_id = country.id" +
                " where price = (select " + value +"(price) from model)";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("brand") + " : " +
                                resultSet.getString("model") + " : " +
                                resultSet.getString("gear_box.type") + " : " +
                                resultSet.getInt("year_of_manufacture") + " : " +
                                resultSet.getInt("price") + " : " +
                                resultSet.getInt("num") + " : " +
                                resultSet.getString("country")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showModelsByCountry(String country) {
        String sql = "select brand, model from model" +
                " join brand on model.brand_id = brand.id" +
                " join country on model.country_id = country.id" +
                " where country = '" + country + "'";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " : " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showCarsCheaperThan(int price) {
        String sql = "select * from model" +
                " join brand on model.brand_id = brand.id" +
                " join gear_box on model.gear_box_type_id = gear_box.id" +
                " join country on model.country_id = country.id" +
                " where price <= '" + price + "'";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString("brand") + " : " +
                                resultSet.getString("model") + " : " +
                                resultSet.getString("gear_box.type") + " : " +
                                resultSet.getInt("year_of_manufacture") + " : " +
                                resultSet.getInt("price") + " : " +
                                resultSet.getInt("num") + " : " +
                                resultSet.getString("country")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showModelsByBrand(String brand) {
        String sql = "select model from model" +
                " join brand on model.brand_id = brand.id" +
                " where brand.brand = '" + brand + "'";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
