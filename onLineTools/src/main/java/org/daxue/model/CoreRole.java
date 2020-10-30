package org.daxue.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CoreRole implements Serializable {
    private static final long serialVersionUID = -2076495930796795359L;

    public Integer id;

    public String name;
}
