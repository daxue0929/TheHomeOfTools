package org.daxue.service.core;

import org.daxue.dao.SysRoleUserMapper;
import org.daxue.model.SysRoleUser;
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

    public List<SysRoleUser> listByUserId(Integer userId) {
        return roleUserMapper.listByUserId(userId);
    }

}
