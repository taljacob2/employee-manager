package com.tal.employeemanager.entity.israelcityapi;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data @Entity @Table public class Record {
    @Id public int _id;
    public int סמל_ישוב;
    public String שם_ישוב;
    public String שם_ישוב_לועזי;
    public String סמל_נפה;
    public String שם_נפה;
    public int סמל_לשכת_מנא;
    public String לשכה;
    public int סמל_מועצה_איזורית;
    public String שם_מועצה;
}
