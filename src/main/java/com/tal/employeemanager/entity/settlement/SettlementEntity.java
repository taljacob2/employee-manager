package com.tal.employeemanager.entity.settlement;

import com.tal.employeemanager.entity.employee.EmployeeEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data @Entity(name = "settlement") @Table public class SettlementEntity
        implements Serializable {

    private static final long serialVersionUID = 6146613623865428922L;

    @Id @Column(unique = true, nullable = false) private int id;

    /**
     * Name in Hebrew.
     */
    @Column(name = "שם_ישוב", unique = true, nullable = false) private String
            name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "settlementEntity")
    @Column(name = "employees") private List<EmployeeEntity> employeeEntities;
}
