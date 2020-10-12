package org.daxue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -8818059456010710913L;


    private Integer id;

    private String name;

    private String password;
}
