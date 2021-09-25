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
 * <ul>
 *     <li>
 * The code:
 * <pre>
 * {@code
 * @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
 *          property = "id")
 * }</pre>
 * prevents the JSON response to send infinity loop, and instead, it sends the
 * "id" of the {@code Entities}.
 *
 * <pre>
 *     </li>
 *     <li>
 * And the code:
 * {@code
 * @JsonIdentityReference(alwaysAsId = true)
 * }</pre>
 * prevents the JSON response to send the whole Object, and in instead, it sends
 * the "id" of it.
 *      </li>
 * </ul>
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id") @Data @Entity(name = "employee") @Table
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = -2330332252646363304L;

    @Id
    // @SequenceGenerator(name = "employee_sequence", schema = "employee_sequence",
    //         allocationSize = 1) @GeneratedValue(generator = "employee_sequence",
    //         strategy = GenerationType.IDENTITY)
    @GeneratedValue // TODO: check if can remove `schema` ^ and will be okay.
    @Column(nullable = false, updatable = false) @Setter(AccessLevel.NONE)
    private Long id;
    @Column(nullable = false) private String name;
    @Column(nullable = false, unique = true) private String email;
    private String jobTitle;
    private String phone;
    private String imageURL;
    @Column(nullable = false, updatable = false) private String code;
    @ManyToOne @JoinColumn(name = "settlement_id") private SettlementEntity
            settlementEntity;
}
