package com.ttn.bootcamp.springDataJPAPart2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//...for single Table strategy...//
/*
@Entity
@DiscriminatorValue("ch")
@Data
public class Check extends Payment{
    @Column(name = "check_number")
    private String checkNumber;
}


 */

//................for table class strategy.........//

@Entity
@Data
@Table(name = "bankcheck")
public class Check extends Payment {
    private String checkNumber;
}


//................for Joined strategy.........//
/*
@Entity
@Data
@Table(name = "bankcheck")
@PrimaryKeyJoinColumn(name = "id")
public class Check extends Payment {

    private String checkNumber;
}
*/