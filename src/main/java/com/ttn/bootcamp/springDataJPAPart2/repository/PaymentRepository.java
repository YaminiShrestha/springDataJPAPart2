package com.ttn.bootcamp.springDataJPAPart2.repository;

import com.ttn.bootcamp.springDataJPAPart2.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
