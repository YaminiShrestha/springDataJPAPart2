package com.ttn.bootcamp.springDataJPAPart2.entities;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Salary {
    private double basicSalary;
    private double bonusSalary;
    private double taxAmount;
    private double specialAllowanceSalary;
}
