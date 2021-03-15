package com.ttn.bootcamp.springDataJPAPart2.repository;

import com.ttn.bootcamp.springDataJPAPart2.entities.EmployeeMapping;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeMappingRepository extends CrudRepository<EmployeeMapping,Integer> {
}
