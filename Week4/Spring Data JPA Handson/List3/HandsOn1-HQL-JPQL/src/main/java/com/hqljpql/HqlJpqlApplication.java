package com.hqljpql;

import com.hqljpql.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HqlJpqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(HqlJpqlApplication.class, args);
    }

    @Bean
    CommandLineRunner run(EmployeeService service) {
        return args -> {
            service.addSampleEmployees();

            System.out.println("IT Employees:");
            service.getByDepartment("IT").forEach(e -> 
                System.out.println(e.getName() + " - " + e.getSalary()));

            System.out.println("Raising salary in IT...");
            service.raiseSalary("IT", 5000);

            System.out.println("Deleting employees with salary < 45000...");
            service.removeLowEarners(45000);

            System.out.println("Remaining Employees:");
            service.getByDepartment("IT").forEach(e -> 
                System.out.println(e.getName() + " - " + e.getSalary()));
        };
    }
}