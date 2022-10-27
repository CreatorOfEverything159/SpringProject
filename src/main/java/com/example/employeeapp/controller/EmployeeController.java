package com.example.employeeapp.controller;

import com.example.employeeapp.dto.EmployeeCreateRequestDto;
import com.example.employeeapp.dto.EmployeeResponseDto;
import com.example.employeeapp.dto.EmployeeUpdateRequestDto;
import com.example.employeeapp.model.EmployeeModel;
import com.example.employeeapp.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> get(@PathVariable Long id) {
        EmployeeModel employeeModel = employeeService.get(id);
        return ResponseEntity.ok().body(new EmployeeResponseDto(employeeModel.getLogin(), employeeModel.getName()));
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody EmployeeCreateRequestDto employeeCreateRequestDto) {
        employeeService.create(
                employeeCreateRequestDto.getLogin(),
                employeeCreateRequestDto.getName(),
                employeeCreateRequestDto.getPassword()
        );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EmployeeUpdateRequestDto employeeUpdateRequestDto) {
        employeeService.update(
                id,
                employeeUpdateRequestDto.getLogin(),
                employeeUpdateRequestDto.getName(),
                employeeUpdateRequestDto.getPassword()
        );
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
