package org.daxue.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleUser implements Serializable {
    private static final long serialVersionUID = -3942755400177443504L;

    public Integer id;

    public Integer sysUserId;

    public Integer sysRoleId;

}
