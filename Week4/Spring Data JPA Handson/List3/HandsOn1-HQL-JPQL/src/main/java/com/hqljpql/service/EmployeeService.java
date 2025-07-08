package com.hqljpql.service;

import com.hqljpql.entity.Employee;
import com.hqljpql.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @PersistenceContext
    private EntityManager em;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getByDepartment(String dept) {
        return repository.findByDepartment(dept);
    }

    @Transactional
    public int raiseSalary(String dept, double amount) {
        return repository.increaseSalaryByDept(dept, amount);
    }

    @Transactional
    public int removeLowEarners(double threshold) {
        return repository.deleteLowSalaryEmployees(threshold);
    }

    public void addSampleEmployees() {
        repository.save(new Employee("Alice", "HR", 50000));
        repository.save(new Employee("Bob", "IT", 60000));
        repository.save(new Employee("Charlie", "IT", 40000));
    }
}