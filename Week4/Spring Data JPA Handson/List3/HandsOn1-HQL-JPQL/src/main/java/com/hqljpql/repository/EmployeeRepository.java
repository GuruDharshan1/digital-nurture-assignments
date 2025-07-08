package com.hqljpql.repository;

import com.hqljpql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.department = ?1")
    List<Employee> findByDepartment(String department);

    @Query("UPDATE Employee e SET e.salary = e.salary + ?2 WHERE e.department = ?1")
    int increaseSalaryByDept(String dept, double amount);

    @Query("DELETE FROM Employee e WHERE e.salary < ?1")
    int deleteLowSalaryEmployees(double threshold);
}