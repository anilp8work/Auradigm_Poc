package com.employee.employeeservice.service.impl;

import com.employee.employeeservice.entity.EmployeeEntity;
import com.employee.employeeservice.request.EmployeeRequest;
import com.employee.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//ToDo: We can enable service layer exception handling
public class EmployeeSeviceImpl implements EmployeeService {


    //ToDo: Replace this with Repository class
    private static List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();

    /**
     * API to save employee data
     * @param request
     * @return
     */
    @Override
    public EmployeeEntity saveEmployee(EmployeeRequest request) {
        //ToDo: Model mapper to copy request data to entity
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(request.getName());
        entity.setSalary(request.getSalary());
        entity.setId(employees.size()+1);// ToDO: No need to set if use real database

        //ToDO: User repository when integrate with DB
        employees.add(entity);

        return entity;
    }

    /**
     * Delete the employee for the given id
     * @param empId
     * @return
     */
    @Override
    public boolean deleteEmployee(final long empId){

        int existEmployeeSize = employees.size();
        //ToDo: Validation for exist of the employee
        employees = employees.stream().filter(emp -> emp.getId() != empId).collect(Collectors.toList());
        int employeesAfterDelete = employees.size();

        return employeesAfterDelete < existEmployeeSize;
    }

    /**
     * Fetch the given employee details by id
     * @param empId
     * @return
     */
    @Override
    public EmployeeEntity readEmployee(final long empId){

        Optional<EmployeeEntity> employeeOption = employees.stream().filter(emp -> emp.getId() == empId).findFirst();

        return employeeOption.isPresent() ? employeeOption.get() : new EmployeeEntity();
    }

    /**
     * Update the employee details for with the given details
     * @param request
     * @return
     */
    @Override
    public boolean updateEmployee(final EmployeeRequest request) {
        boolean isUpdated = false;
        for(EmployeeEntity entity : employees){
            if(entity.getId() == request.getId()){
                isUpdated = true;
                entity.setName(request.getName());
                entity.setSalary(request.getSalary());
            }
        }
        return isUpdated;
    }
}
