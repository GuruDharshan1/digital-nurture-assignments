package com.cts;

import com.cts.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        testGetAverageSalary();
    }

    public static void testGetAverageSalary() {
        double avgSalary = employeeService.getAverageSalary(1);
        System.out.println("Average Salary of Department 1: " + avgSalary);
    }
}
