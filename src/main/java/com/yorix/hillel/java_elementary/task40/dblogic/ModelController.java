package com.yorix.hillel.java_elementary.task40.dblogic;

import com.yorix.hillel.java_elementary.task40.domains.Model;
import com.yorix.hillel.java_elementary.task40.interfaces.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ModelController implements Controller<Model> {
    private Connection connection;

    public ModelController() {
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/auto" +
                            "?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC",
                            "test", "test");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Model entity) {
    }

    @Override
    public void update(Model item) {

    }

    @Override
    public Model getById(int id) {
        return null;
    }

    @Override
    public List<Model> getAll() {
        return null;
    }

    @Override
    public void delete(Model item) {

    }

    @Override
    public void deleteAll() {

    }
}
