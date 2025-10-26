package com.chandanpathak2005.gmail.com.Employee.controller;

import com.chandanpathak2005.gmail.com.Employee.employeeDto.AddEmployeeData;
import com.chandanpathak2005.gmail.com.Employee.employeeDto.EmployeeDto;

import com.chandanpathak2005.gmail.com.Employee.employeeEntity.Employee;
import com.chandanpathak2005.gmail.com.Employee.service.imple.EmployeeServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImp employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> grtAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> insetEmployee(@RequestBody AddEmployeeData addEmployeeData){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.insertEmployee(addEmployeeData));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id,@RequestBody AddEmployeeData addEmployeeData){
        return ResponseEntity.ok(employeeService.updateEmployee(id,addEmployeeData));
    }
}
