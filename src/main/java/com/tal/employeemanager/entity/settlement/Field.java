package com.tal.employeemanager.entity.settlement;

import lombok.Data;

import java.io.Serializable;

@Data public class Field implements Serializable {

    private static final long serialVersionUID = 2381600010233446660L;

    public String id;
    public String type;
    public Info info;
}
