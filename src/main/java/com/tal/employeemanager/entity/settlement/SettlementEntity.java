package com.tal.employeemanager.entity.settlement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tal.employeemanager.entity.employee.EmployeeEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
        property = "id") @Data @Entity(name = "settlement") @Table
public class SettlementEntity implements Serializable {

    private static final long serialVersionUID = 6146613623865428922L;

    @Id @Column(unique = true, nullable = false) private int id;

    @Column(unique = true, nullable = false) private String name;

    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "settlementEntity")
    @JsonBackReference @Column(name = "employees") private List<EmployeeEntity>
            employeeEntities;
}
