package com.employee.employeeservice.controller;

import com.employee.employeeservice.entity.EmployeeEntity;
import com.employee.employeeservice.request.EmployeeRequest;
import com.employee.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
//ToDo: We can enable controller layer exception handling
@RestController("v1/employee")
public class EmployeeController {

    @Autowired(required=true)
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeEntity> saveEmployee(/*@Validated*/ @RequestBody EmployeeRequest request){

        EmployeeEntity employee = employeeService.saveEmployee(request);

        return new ResponseEntity(employee, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Object> updateEmployee(/*@Validated*/ @RequestBody EmployeeRequest request){

        boolean status = employeeService.updateEmployee(request);

        //ToDo: Create a generic response bean object to leverage for common responses
        Map<String, Object> response = new HashMap<String, Object>(2);
        response.put("status",status);

        return new ResponseEntity(response, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<Object> deleteEmployee(@RequestParam Long empId){

        boolean status = employeeService.deleteEmployee(empId);

        //ToDo: Create a generic response bean object to leverage for common responses
        Map<String, Object> response = new HashMap<String, Object>(2);
        response.put("status", status);

        return new ResponseEntity(response, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<EmployeeEntity> findEmployee( @RequestParam Long empId){

        EmployeeEntity employee = employeeService.readEmployee(empId);

        return new ResponseEntity(employee, HttpStatus.OK);

    }


}
