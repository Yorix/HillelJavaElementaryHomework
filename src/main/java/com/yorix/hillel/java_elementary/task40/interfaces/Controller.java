package com.yorix.hillel.java_elementary.task40.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface Controller<E> {
    void create(E entity);
    void update(E entity);
    E getById(int id);
    List<E> getAll();
    void delete(E entity);
    void deleteAll();


    default void closePreparedStatement(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
