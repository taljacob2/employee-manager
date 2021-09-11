package com.tal.employeemanager.entity.record;

import lombok.Data;

import java.io.Serializable;

@Data public class Info implements Serializable {

    private static final long serialVersionUID = -4603315819240619320L;

    public String label;
    public String notes;
    public String type_override;
}
