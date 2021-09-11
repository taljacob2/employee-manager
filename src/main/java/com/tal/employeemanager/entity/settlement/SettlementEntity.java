package com.tal.employeemanager.entity.settlement;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data @Entity(name = "settlement") @Table public class SettlementEntity
        implements Serializable {

    private static final long serialVersionUID = 6146613623865428922L;

    @Id @Column(nullable = false) public int _id;

    /**
     * Name in Hebrew.
     */
    @Column(name = "שם_ישוב") public String name;
}
