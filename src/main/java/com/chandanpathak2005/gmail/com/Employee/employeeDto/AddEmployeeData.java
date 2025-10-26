package com.chandanpathak2005.gmail.com.Employee.employeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeData {
    private String name;
    private int age;
    private String address;
}
