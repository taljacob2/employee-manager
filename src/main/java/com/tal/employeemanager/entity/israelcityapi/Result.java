package com.tal.employeemanager.entity.israelcityapi;

import lombok.Data;

import java.util.List;

@Data public class Result{
    public boolean include_total;
    public int limit;
    public String records_format;
    public String resource_id;
    public Object total_estimation_threshold;
    public List<Record> records;
    public List<Field> fields;
    public Links _links;
}
