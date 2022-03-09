package com.homeapp.autowater.domain.user.model;

import lombok.Data;

@Data
public class Salary {
    private String userId;
    private String yearMonth;
    private Integer salary;
}