package com.tal.employeemanager.entity.settlement;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data public class Result implements Serializable {

    private static final long serialVersionUID = -8334649255571298736L;

    public boolean include_total;
    public int limit;
    public String records_format;
    public String resource_id;
    public Object total_estimation_threshold;
    public List<Record> records;
    public List<Field> fields;
    public Links _links;
}
