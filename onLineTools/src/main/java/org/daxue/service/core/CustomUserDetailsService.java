package org.daxue.service.core;

import org.daxue.model.SysRole;
import org.daxue.model.SysRoleUser;
import org.daxue.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


    private SysUserService userService;


    private SysRoleService roleService;

    private SysRoleUserService roleUserService;

    @Autowired
    public CustomUserDetailsService(SysUserService userService,
                                    SysRoleService roleService,
                                    SysRoleUserService roleUserService) {
        this.userService = userService;
        this.roleService = roleService;
        this.roleUserService = roleUserService;

    }


    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        SysUser user = userService.selectByName(username);

        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 添加权限
        List<SysRoleUser> userRoles = roleUserService.listByUserId(user.getId());
        for (SysRoleUser userRole : userRoles) {
            SysRole role = roleService.selectById(userRole.getSysRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // 返回UserDetails实现类
        return new User(user.getName(), user.getPassword(), authorities);
    }
}
