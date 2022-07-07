package com.employee.employeeservice.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    //ToDO: Enable API side validations on fields
    private long id;
    private String name;
    private float salary;
}
