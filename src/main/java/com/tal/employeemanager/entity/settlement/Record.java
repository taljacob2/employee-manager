package com.tal.employeemanager.entity.settlement;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * This class is a <i>IsraelCityEntity</i>.
 */
@Data @Entity @Table public class Record implements Serializable {

    private static final long serialVersionUID = 4161791001550581801L;

    @Id public int _id;
    public int סמל_ישוב;
    @Column(name = "settlement_name") public String שם_ישוב;
    public String שם_ישוב_לועזי;
    public String סמל_נפה;
    public String שם_נפה;
    public int סמל_לשכת_מנא;
    public String לשכה;
    public int סמל_מועצה_איזורית;
    public String שם_מועצה;
}
