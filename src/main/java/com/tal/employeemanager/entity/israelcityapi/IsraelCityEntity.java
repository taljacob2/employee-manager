package com.tal.employeemanager.entity.israelcityapi;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data /*@Entity @Table */public class IsraelCityEntity implements Serializable {

    private static final long serialVersionUID = -1436104445963257409L;

    @Id @SequenceGenerator(name = "israel_city_sequence",
            schema = "israel_city_sequence", allocationSize = 1)
    @GeneratedValue(generator = "israel_city_sequence",
            strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false) @Setter(AccessLevel.NONE)
    private Long id;


}
