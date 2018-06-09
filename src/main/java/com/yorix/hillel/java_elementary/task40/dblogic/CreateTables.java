package com.yorix.hillel.java_elementary.task40.dblogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class CreateTables {
    private static Connection connection;

    public static void createAllTables() {
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/auto" +
                                    "?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC",
                            "test", "test");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        deleteAll();
        createAll();
        fillAll();
    }


    private static void create(String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createAll() {
        String sql1 = "create table model (" +
                "   id int not null primary key," +
                "   mark_id int," +
                "   model varchar(100)," +
                "   gear_box_type_id int," +
                "   year_of_manufacture year," +
                "   price decimal," +
                "   num int," +
                "   country_id int );";
        String sql2 = "create table mark (" +
                "   id int not null primary key," +
                "   mark varchar(50));";
        String sql3 = "create table gear_box (" +
                "   id int not null primary key auto_increment," +
                "   `type` varchar(10));";
        String sql4 = "create table country (" +
                "   id int not null primary key auto_increment," +
                "   country varchar(50),\n" +
                "   country_code varchar(3));";
        create(sql1);
        create(sql2);
        create(sql3);
        create(sql4);
    }

    private static void fill(String tableFilePath) {
        File file = new File(tableFilePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine()).append("\n");
        }
        String sql = builder.toString();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void fillAll() {
        fill("res/task40/fillTable1.sql");
        fill("res/task40/fillTable2.sql");
        fill("res/task40/fillTable3.sql");
        fill("res/task40/fillTable4.sql");
        fill("res/task40/updateModel1.sql");
        fill("res/task40/updateModel2.sql");
        fill("res/task40/updateModel3.sql");
        fill("res/task40/updateModel4.sql");
        fill("res/task40/updateModel5.sql");
    }

    private static void deleteAll() {
        String sql = "drop tables if exists model, mark, gear_box, country;";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
