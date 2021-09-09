package com.tal.employeemanager.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data @Entity(name = "city") @Table public class CityEntity
        implements Serializable {

    private static final long serialVersionUID = 2056536010779857852L;

    @Id @GeneratedValue @Column(nullable = false, updatable = false)
    @Setter(AccessLevel.NONE) private Long id;

    private String name;
}
