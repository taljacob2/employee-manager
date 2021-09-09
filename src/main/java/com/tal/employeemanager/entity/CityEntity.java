package com.tal.employeemanager.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data @Entity(name = "city") @Table public class CityEntity
        implements Serializable {

    private static final long serialVersionUID = 2056536010779857852L;

    @Id @SequenceGenerator(name = "city_sequence", schema = "city_sequence",
            allocationSize = 1) @GeneratedValue(generator = "city_sequence",
            strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) @Setter(AccessLevel.NONE)
    private Long id;

    @Column(unique = true, nullable = false) private String name;
}
