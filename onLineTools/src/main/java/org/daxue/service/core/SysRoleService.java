package org.daxue.service.core;

import org.daxue.dao.SysRoleMapper;
import org.daxue.model.CoreRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {

    private SysRoleMapper roleMapper;

    @Autowired
    public SysRoleService(SysRoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public CoreRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
}
