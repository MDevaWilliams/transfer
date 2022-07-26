package com.demo.emp.controller;


import com.demo.emp.entity.EmpClass;
import com.demo.emp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService service;

    @GetMapping("/Employee/{id}")
    public EmpClass getEmployeeById(@PathVariable int id) {
        service.getEmployeeById(id);
        return null;
    }

    @GetMapping("/Employee")
    public List<EmpClass> getEmployee(){
        return service.getAllEmployee();
    }

    @GetMapping("/{field}")
    public List<EmpClass> getAllEmployeeByDescendingOrder(@PathVariable String field){
        return service.getAllEmployeeByDescendingOrder(field);
    }

    @PostMapping("/students")
    public EmpClass saveEmployee(@RequestBody EmpClass Employee) {
        return service.addEmployee(Employee);
    }

    @PutMapping("/students")
    public EmpClass editEmployee(@RequestBody EmpClass Employee) {
        return service.editEmployee(Employee);
    }

    @DeleteMapping("/students/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

}
