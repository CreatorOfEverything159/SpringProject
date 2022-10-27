package com.example.employeeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeUpdateRequestDto {
    String login;
    String name;
    String password;
}
