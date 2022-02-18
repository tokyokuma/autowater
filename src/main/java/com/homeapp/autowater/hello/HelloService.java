package com.homeapp.autowater.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository repository;

    //get employee
    public Employee getEmployee(String id){
        //search
        Map<String, Object>map = repository.findById(id);

        //get value from Map
        String employeeId = (String)map.get("id");
        String name = (String)map.get("name");
        int age = (Integer)map.get("age");

        //set value to Employee class
        Employee employee = new Employee();
        employee.setEmployeeId((employeeId));
        employee.setEmployeeName(name);
        employee.setEmployeeAge(age);

        return employee;
    }
}
