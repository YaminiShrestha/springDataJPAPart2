package com.ttn.bootcamp.springDataJPAPart2.entities;

import lombok.Data;


import javax.persistence.*;

@Entity

@Data
@Table(name = "employee_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int id;
    @Column(name = "emp_first_name")
    private String firstName;
    @Column(name = "emp_last_name")
    private String lastName;
    @Column(name = "emp_salary")
    private double salary;
    @Column(name = "emp_age")
    private int age;
}
