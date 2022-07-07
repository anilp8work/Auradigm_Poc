package com.employee.employeeservice.entity;

import lombok.Data;

//ToDo: Actually its a Entity for  table, have to integrate with db
@Data
public class EmployeeEntity {
    private long id;
    private String name;
    private float salary;
}
