package com.tal.employeemanager.entity.employee;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tal.employeemanager.entity.settlement.SettlementEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <i>IMPORTANT NOTE:</i>
 * <pre>
 * The code:
 * {@code
 * @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
 *          property = "id")
 * }</pre>
 * prevents the JSON response to send infinity loop. And instead, it sends the
 * "id" of the {@code Entities}.
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id") @Data @Entity(name = "employee") @Table
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = -2330332252646363304L;

    @Id
    @SequenceGenerator(name = "employee_sequence", schema = "employee_sequence",
            allocationSize = 1) @GeneratedValue(generator = "employee_sequence",
            strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) @Setter(AccessLevel.NONE)
    private Long id;
    @Column(nullable = false) private String name;
    @Column(nullable = false, unique = true) private String email;
    private String jobTitle;
    private String phone;
    private String imageURL;
    @ManyToOne @JoinColumn(name = "שם_ישוב", referencedColumnName = "שם_ישוב")
    private SettlementEntity settlementEntity;
    @Column(nullable = false, updatable = false) private String code;
}
