package org.daxue.base.service;

import org.daxue.base.dao.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public abstract class AbstractBaseService<T> implements BaseService<T> {

    @Autowired
    BaseMapper baseMapper;

    @Override
    public int getCount() throws SQLException {
        return baseMapper.getCount();
    }

    @Override
    public boolean update(final Integer id, final T t) {
        return baseMapper.update(id, t);
    }

    @Override
    public T get(final Integer id) {
        return null;
    }

    @Override
    public boolean delete(final Integer id) {
        return false;
    }

    @Override
    public boolean add(final T t) {
        return false;
    }
}
