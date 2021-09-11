package com.tal.employeemanager.entity.settlement;

import lombok.Data;

import java.io.Serializable;

@Data public class Root implements Serializable {

    private static final long serialVersionUID = -7274718537769655748L;

    public String help;
    public boolean success;
    public Result result;
}
