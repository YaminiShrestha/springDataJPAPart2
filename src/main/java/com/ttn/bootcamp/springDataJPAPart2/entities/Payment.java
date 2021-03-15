package com.ttn.bootcamp.springDataJPAPart2.entities;

import lombok.Data;


import javax.persistence.*;
//................... Single Table Strategy ....................//
/*
@Entity
@Table(name = "payment")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pmode",discriminatorType = DiscriminatorType.STRING)
public class Payment {
    @Id
    @GeneratedValue
    private int id;
    private double amount;
}


 */

//....................Table Per Class Strategy.................//

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Payment {
    @Id
    private int id;
    private double amount;
}




//....................Table JOINED.................//
/*
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {
    @Id
    private int id;
    private double amount;
}

 */