package com.project.EverestConsultancy.service;

import com.project.EverestConsultancy.entity.Student;
import com.project.EverestConsultancy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> saveStudents(List<Student> students) {
        return studentRepo.saveAll(students);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> existingStudent = studentRepo.findById(id);
        if (existingStudent.isPresent()) {
            Student stu = existingStudent.get();
            stu.setName(studentDetails.getName());
            stu.setEmail(studentDetails.getEmail());
            stu.setAddress(studentDetails.getAddress());
            return studentRepo.save(stu);
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<Student> existingStudent = studentRepo.findById(id);
        if (existingStudent.isPresent()) {
            studentRepo.deleteById(id);
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }
}
