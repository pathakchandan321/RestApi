package com.chandanpathak2005.gmail.com.Employee.repository;

import com.chandanpathak2005.gmail.com.Employee.employeeEntity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
