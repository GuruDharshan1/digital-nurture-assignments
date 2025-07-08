package com.example.ormlearn;

import com.example.ormlearn.model.Employee;
import com.example.ormlearn.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(EmployeeService employeeService) {
        return args -> {
            List<Employee> employees = employeeService.getAllEmployees();
            employees.forEach(System.out::println);
        };
    }
}
