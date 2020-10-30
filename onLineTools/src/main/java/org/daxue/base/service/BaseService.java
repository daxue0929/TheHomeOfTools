package org.daxue.base.service;

import java.sql.SQLException;

public interface BaseService<T> {

    T get(Integer id);

    int getCount()throws SQLException;

    boolean delete(Integer id);

    boolean add(T t);

    boolean update(Integer id, T t);

}
