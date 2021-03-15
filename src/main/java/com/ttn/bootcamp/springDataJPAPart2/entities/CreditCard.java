package com.ttn.bootcamp.springDataJPAPart2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//..........for single Table Strategy...........//
/*
@Entity
@DiscriminatorValue("cc")
@Data
public class CreditCard extends Payment{
    @Column(name = "card_number")
    private String cardNumber;
}


 */

//................for Table Per Class Strategy.........//

@Entity
@Data
@Table(name = "card")
public class CreditCard extends Payment{
    private String cardNumber;
}

//................for Joined........//
/*
@Entity
@Data
@Table(name = "card")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Payment{

    private String cardNumber;
}
*/
