package com.employee.employeeservice.service;

import com.employee.employeeservice.entity.EmployeeEntity;
import com.employee.employeeservice.request.EmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {


    public EmployeeEntity saveEmployee(EmployeeRequest request);
    public boolean deleteEmployee(final long empId);
    public EmployeeEntity readEmployee(final long empId);
    public boolean updateEmployee(final EmployeeRequest request);

}
