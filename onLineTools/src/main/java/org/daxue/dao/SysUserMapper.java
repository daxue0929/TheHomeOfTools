package org.daxue.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.daxue.model.CoreUser;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper {

    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    CoreUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    CoreUser selectByName(String name);

    @Select("SELECT * FROM sys_user WHERE account = #{account}")
    CoreUser selectByAccount(String account);
}
