package com.tal.employeemanager.entity.record;

import lombok.Data;

import java.io.Serializable;

@Data public class Links implements Serializable {

    private static final long serialVersionUID = -9218354603858287176L;

    public String start;
    public String next;
}
