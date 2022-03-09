package com.homeapp.autowater.form;

import java.util.Date;
import java.util.List;

import com.homeapp.autowater.domain.user.model.Department;
import com.homeapp.autowater.domain.user.model.Salary;

import lombok.Data;

@Data
public class UserDetailForm {
    private String userId;
    private String password;
    private String userName;
    private Date birthday;
    private Integer age;
    private Integer gender;
    private Department department;
    private List<Salary> salaryList;
}
