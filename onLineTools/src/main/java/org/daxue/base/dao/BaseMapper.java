package org.daxue.base.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Mapper
@Repository
public interface BaseMapper<T> {

    T get(Integer id);

    //  查询总记录数
    int getCount()throws SQLException;

    boolean delete(Integer id);

    boolean add(T t);

    boolean update(Integer id, T t);

}
