package com.yorix.hillel.java_elementary.task41.dao.interfaces;

import java.util.Collection;

public interface Controller<E, K> {
    void create(E entity);

    void createAll(Collection<E> list);

    E get(K key);

    void update(K key);

    void delete(K key);
}
