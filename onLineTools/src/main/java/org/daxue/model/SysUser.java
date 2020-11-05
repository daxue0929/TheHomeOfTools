package org.daxue.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @JsonInclude(JsonInclude.Include.NON_NULL)
 * 对于属性为null的字段，不序列化。
 * 如果是一个接口返回的json对象，要是不序列化，如何保证前端取对象属性时候的足够友好。
 * 就算为null，也要有个键吧。
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true) // 忽略json对象多余的字段
//@JsonInclude(JsonInclude.Include.NON_NULL)
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
