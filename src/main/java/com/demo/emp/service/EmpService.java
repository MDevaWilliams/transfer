package com.demo.emp.service;


import com.demo.emp.entity.EmpClass;
import com.demo.emp.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository repository;

    // to add the student
    public EmpClass addEmployee(EmpClass Employee) {
        return repository.save(Employee);
    }

    // to get the student based on his id
    public EmpClass getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    // to get all the students
    public List<EmpClass> getAllEmployee() {
        return repository.findAll();
    }

    // to get the element based on ascending order
    public List<EmpClass> getAllEmployeeByDescendingOrder(String field) {
        return repository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    // to edit the Employee
    public EmpClass editEmployee(EmpClass Employee) {
        EmpClass ExistingEmployee = repository.findById(Employee.getId()).orElse(null);
        ExistingEmployee.setName(Employee.getName());
        ExistingEmployee.setSalary(Employee.getSalary());
        ExistingEmployee.setDesignation(Employee.getDesignation());
        return repository.save(ExistingEmployee);
    }

    // to delete the Employee
    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee deleted";
    }
}

