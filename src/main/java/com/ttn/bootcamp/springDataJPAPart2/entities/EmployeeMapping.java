package com.ttn.bootcamp.springDataJPAPart2.entities;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "employeemapping")
public class EmployeeMapping {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @Embedded
    private Salary salary;

}
