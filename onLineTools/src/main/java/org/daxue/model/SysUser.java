package org.daxue.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@Accessors(chain = true)
public class SysUser implements Serializable, UserDetails {
    private static final long serialVersionUID = -8818059456010710913L;


    private Integer id;

    private String name;

    private String password;

    private String email;

    private String phone;

    private String createTime;

    private String updateTime;

    // 登录用户名
    private String account;

    public static SysUser genSysUserMock() {
        SysUser sysUser = new SysUser();
        return sysUser.setAccount("accountUserName")
            .setName("daxue")
            .setEmail("daxue0929@qq.com")
            .setCreateTime(new Date().toString())
            .setPassword("123415");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return String.valueOf(account);
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
