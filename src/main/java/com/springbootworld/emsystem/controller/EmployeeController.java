package com.springbootworld.emsystem.controller;

import com.springbootworld.emsystem.dto.EmployeeDto;
import com.springbootworld.emsystem.mapper.EmployeeMapper;
import com.springbootworld.emsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController //Class becomes Spring MVC Rest Controller to handle HTTP requests
@RequestMapping("/api/employees") //To define the base URl for all REST APIs within this controller
public class EmployeeController {

    public EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping //To map incoming HTTP POST request to this method
    //@RequestBody: Will extract JSON from HTTP request and convert to EmployeeDto Java Object
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build GET Employee REST API
    @GetMapping("{id}") //To map incoming HTTP GET request to this method
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build GET All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build UPDATE Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Build DELETE Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!...");
    }

}
