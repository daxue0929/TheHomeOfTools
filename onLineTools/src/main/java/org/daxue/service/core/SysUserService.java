package org.daxue.service.core;

import org.daxue.base.service.AbstractBaseService;
import org.daxue.dao.SysUserMapper;
import org.daxue.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SysUserService extends AbstractBaseService<SysUser> implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    public SysUserService(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }

    public SysUser selectByAccount(String account){
        return userMapper.selectByAccount(account);
    }

    @Override
    public UserDetails loadUserByUsername(final String account) throws UsernameNotFoundException {
        UserDetails userDetails = userMapper.selectByAccount(account);
        return userDetails;
    }
}
