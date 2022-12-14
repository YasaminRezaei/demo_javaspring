package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
       Optional<Student> findByEmail= studentRepository.findStudentByEmail(student.getEmail());
        if (findByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
       System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exist =studentRepository.existsById(studentId);
        if(!exist){
            throw new IllegalStateException("student with id " + studentId+"does not found");
        }
        else {
            studentRepository.deleteById(studentId);
        }
    }
}
