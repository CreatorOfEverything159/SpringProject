package com.example.employeeapp.repository;

import com.example.employeeapp.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    EmployeeEntity findByLogin(String login);

    /*List<EmployeeEntity> getEmployeeEntities();
    Page<EmployeeEntity> getEmployeeEntities(Pageable pageable);*/
}
