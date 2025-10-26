package com.chandanpathak2005.gmail.com.Employee.service;

import com.chandanpathak2005.gmail.com.Employee.employeeDto.AddEmployeeData;
import com.chandanpathak2005.gmail.com.Employee.employeeDto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployee();

    EmployeeDto insertEmployee(AddEmployeeData addEmployeeData);

    void deleteEmployee(long id);

    EmployeeDto updateEmployee(long id, AddEmployeeData addEmployeeData);
}
