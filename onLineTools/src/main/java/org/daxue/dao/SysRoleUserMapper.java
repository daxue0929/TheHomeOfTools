package org.daxue.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.daxue.model.CoreRoleUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysRoleUserMapper {

    @Select("SELECT * FROM sys_role_user WHERE sys_user_id = #{userId}")
    List<CoreRoleUser> listByUserId(Integer userId);
}
