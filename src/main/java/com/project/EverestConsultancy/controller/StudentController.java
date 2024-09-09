package com.project.EverestConsultancy.controller;

import com.project.EverestConsultancy.dto.ResponseMessage;
import com.project.EverestConsultancy.entity.Student;
import com.project.EverestConsultancy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<ResponseMessage> saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>(new ResponseMessage("Student is added"), HttpStatus.CREATED);
    }

    @PostMapping("/batchIntake")
    public ResponseEntity<ResponseMessage> saveStudents(@RequestBody List<Student> students) {
        studentService.saveStudents(students);
        return new ResponseEntity<>(new ResponseMessage("Students have been added"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseMessage("Student not found with ID " + id), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateStudentById(@PathVariable long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return new ResponseEntity<>(new ResponseMessage("Student is updated"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteStudentById(@PathVariable long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(new ResponseMessage("Student is deleted"), HttpStatus.NO_CONTENT);
    }
}
