package com.example.employeeapp.service;

import com.example.employeeapp.entity.EmployeeEntity;
import com.example.employeeapp.exception.AlreadyExistsException;
import com.example.employeeapp.exception.NotFountException;
import com.example.employeeapp.model.EmployeeModel;
import com.example.employeeapp.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    EmployeeEntity getEntity(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFountException("Пользователь не найден"));
    }

    private void isExists(String login) {
        if (employeeRepository.findByLogin(login) != null) {
            throw new AlreadyExistsException("Пользователь с логином '" + login + "' уже существует");
        }
    }

    public EmployeeModel get(Long id) throws NotFountException {
        EmployeeEntity employee = getEntity(id);
        return new EmployeeModel(employee.getLogin(), employee.getName());
    }

    public void create(String login, String name, String password) {
        isExists(login);
        EmployeeEntity employee = new EmployeeEntity();
        employee.setLogin(login);
        employee.setName(name);
        employee.setPassword(password);
        employeeRepository.save(employee);
    }

    public void update(Long id, String login, String name, String password) {
        EmployeeEntity employee = getEntity(id);
        if (!employee.getLogin().equals(login)) {
            isExists(login);
        }
        employee.setLogin(login);
        employee.setName(name);
        employee.setPassword(password);
        employeeRepository.save(employee);
    }

    public void delete(Long id) {
        EmployeeEntity employee = getEntity(id);
        employeeRepository.delete(employee);
    }
}
