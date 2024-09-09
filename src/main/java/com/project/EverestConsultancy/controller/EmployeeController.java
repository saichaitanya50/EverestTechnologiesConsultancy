package com.project.EverestConsultancy.controller;

import com.project.EverestConsultancy.dto.ResponseMessage;
import com.project.EverestConsultancy.entity.Employee;
import com.project.EverestConsultancy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ResponseMessage> saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(new ResponseMessage("Employee is added"), HttpStatus.CREATED);
    }

    @PostMapping("/batchIntake")
    public ResponseEntity<ResponseMessage> saveEmployees(@RequestBody List<Employee> employees) {
        employeeService.saveEmployees(employees);
        return new ResponseEntity<>(new ResponseMessage("Employees have been added"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable long id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseMessage("Employee not found with ID " + id), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateEmployeeById(@PathVariable long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(new ResponseMessage("Employee is updated"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(new ResponseMessage("Employee is deleted"), HttpStatus.NO_CONTENT);
    }
}
