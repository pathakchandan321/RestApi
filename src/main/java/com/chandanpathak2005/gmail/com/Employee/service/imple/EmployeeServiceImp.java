package com.chandanpathak2005.gmail.com.Employee.service.imple;

import com.chandanpathak2005.gmail.com.Employee.employeeDto.AddEmployeeData;
import com.chandanpathak2005.gmail.com.Employee.employeeDto.EmployeeDto;
import com.chandanpathak2005.gmail.com.Employee.employeeEntity.Employee;
import com.chandanpathak2005.gmail.com.Employee.repository.EmployeeRepository;
import com.chandanpathak2005.gmail.com.Employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> emp=employeeRepository.findAll();
        return emp.stream().map(employee->modelMapper.map(employee,EmployeeDto.class)).toList();
    }

    @Override
    public EmployeeDto insertEmployee(AddEmployeeData addEmployeeData) {
        Employee newEmp=modelMapper.map(addEmployeeData,Employee.class);
        Employee emp=employeeRepository.save(newEmp);
        return modelMapper.map(emp,EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(long id) {
        if(!employeeRepository.existsById(id)){
            throw new IllegalArgumentException("employee not exist by id:"+id);
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto updateEmployee(long id, AddEmployeeData addEmployeeData) {
        Employee existEmp=employeeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("employee not exist with id: "+id));
        existEmp.setName(addEmployeeData.getName());
        existEmp.setAge(addEmployeeData.getAge());
        existEmp.setAddress(addEmployeeData.getAddress());
        Employee saveEmp=employeeRepository.save(existEmp);
        return modelMapper.map(saveEmp,EmployeeDto.class);
    }
}
