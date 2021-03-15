package com.ttn.bootcamp.springDataJPAPart2;

import com.ttn.bootcamp.springDataJPAPart2.entities.*;
import com.ttn.bootcamp.springDataJPAPart2.repository.EmployeeMappingRepository;
import com.ttn.bootcamp.springDataJPAPart2.repository.EmployeeRepository;
import com.ttn.bootcamp.springDataJPAPart2.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class SpringDataJpaPart2ApplicationTests {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private EmployeeMappingRepository employeeMappingRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testEmployeeCreate() {
        Employee employee = new Employee();
        employee.setFirstName("Harry");
        employee.setLastName("singh");
        employee.setSalary(5000);
        employee.setAge(25);
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("Alex");
        employee2.setLastName("Smith");
        employee2.setSalary(8000);
        employee2.setAge(28);
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Brian");
        employee3.setLastName("Lu");
        employee3.setSalary(9000);
        employee3.setAge(67);
        employeeRepository.save(employee3);
    }

    @Test
    public void testAllEmployeesHavingSalaryGreaterThanAverageSalary() {
        List<Object[]> empData = employeeRepository.findAllEmployeesHavingSalaryGreaterThanAverageSalary();
        for (Object[] obj : empData) {
            System.out.println(obj[0] + " " + obj[1]);
        }
    }

    @Test
    @Transactional
    public void testUpdateSalaryOfEmployeeLessThanAvg() {
        double salary = 5000;
        double averageSalary = employeeRepository.findAvgSalary();
        employeeRepository.updateSalaryOfEmployeeLessThanAverageSalary(salary, averageSalary);
    }
    @Test
    @Transactional
    @Rollback(value = false)
    public void testDeleteEmployeeSalary(){
        employeeRepository.deleteEmployeeSalary(employeeRepository.findMinSalary());
    }

    @Test
    public void testGetAllEmployeeWhoseNameEndsWith() {
        List<Object[]> empData = employeeRepository.getAllEmployeeWhoseNameEndsWith();
        for (Object[] obj : empData) {
            System.out.println(obj[0] + " " + obj[1]);
        }
    }

    @Test
    @Transactional
   @Rollback(value = false)
    public void testDeleteEmployeeHavingAgeGreaterThan() {
        employeeRepository.deleteEmployeeHavingAgeGreaterThan(45);
        ;
    }

    @Test
    public void cardPayment() {
        CreditCard cc = new CreditCard();
        cc.setId(5);
        cc.setAmount(500);
        cc.setCardNumber("8776585");
        paymentRepository.save(cc);

    }

    @Test
    public void checkPayment() {
        Check ch = new Check();
        ch.setId(6);
        ch.setAmount(700);
        ch.setCheckNumber("789099");
        paymentRepository.save(ch);

    }

    //    ques 5
    @Test
    public void employeeMapping() {
        EmployeeMapping employeeMapping = new EmployeeMapping();
        employeeMapping.setId(1);
        employeeMapping.setFirstName("Alex");
        employeeMapping.setLastName("Smith");
        employeeMapping.setAge(25);
        Salary salary = new Salary();
        salary.setBasicSalary(4000);
        salary.setBonusSalary(500);
        salary.setTaxAmount(4500);
        salary.setSpecialAllowanceSalary(2000);
        employeeMapping.setSalary(salary);
        employeeMappingRepository.save(employeeMapping);
    }
}
