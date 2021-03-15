package com.ttn.bootcamp.springDataJPAPart2.repository;

import com.ttn.bootcamp.springDataJPAPart2.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    //......................jpql query....................//
    @Query("select firstName, lastName from Employee where " +
            "salary > (select AVG(salary) from Employee)" +
            " ORDER BY age ASC, salary DESC")
    List<Object[]> findAllEmployeesHavingSalaryGreaterThanAverageSalary();


    @Query("select avg(salary) from Employee")
    double findAvgSalary();


    @Modifying
    @Query("update Employee set salary =:salary where salary < :averageSalary")
    void updateSalaryOfEmployeeLessThanAverageSalary(@Param("salary") double salary, @Param("averageSalary") double averageSalary);

    @Query("select min(salary) from Employee")
    double findMinSalary();


    @Modifying// Q3 JPQL
    @Query("delete from Employee where salary = :findMinSalary")
    void deleteEmployeeSalary(@Param("findMinSalary") double findMinSalary);

    //....................native query..............//
    @Query(value = "select emp_id,emp_first_name from employee_table where " +
            "emp_last_name like '%singh'", nativeQuery = true)
    List<Object[]> getAllEmployeeWhoseNameEndsWith();

    @Modifying
    @Query(value = "delete from employee_table where emp_age>:age", nativeQuery = true)
    void deleteEmployeeHavingAgeGreaterThan(@Param("age") int age);
}