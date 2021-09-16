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

    @Id @Column(unique = true, nullable = false) public int id;

    /**
     * Name in Hebrew.
     */
    @Column(name = "שם_ישוב", unique = true) public String name;
}
