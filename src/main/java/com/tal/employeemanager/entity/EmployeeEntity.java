package com.tal.employeemanager.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data @Entity @Table public class EmployeeEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id @GeneratedValue @Column(nullable = false, updatable = false)
    @Setter(AccessLevel.NONE) private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageURL;
    @Column(nullable = false, updatable = false) private String code;
}