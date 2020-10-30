package org.daxue.service.core;

import org.daxue.dao.SysRoleUserMapper;
import org.daxue.model.CoreRoleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleUserService {

    private SysRoleUserMapper roleUserMapper;

    @Autowired
    public SysRoleUserService(SysRoleUserMapper roleUserMapper) {
        this.roleUserMapper = roleUserMapper;
    }

    public List<CoreRoleUser> listByUserId(Integer userId) {
        return roleUserMapper.listByUserId(userId);
    }

}
