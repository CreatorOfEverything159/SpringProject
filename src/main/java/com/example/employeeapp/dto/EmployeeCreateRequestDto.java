package com.example.employeeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeCreateRequestDto {
    private String login;
    private String name;
    private String password;
}
