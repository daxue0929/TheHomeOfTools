package org.daxue.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.daxue.model.CoreRole;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysRoleMapper {

    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    CoreRole selectById(Integer id);
}
