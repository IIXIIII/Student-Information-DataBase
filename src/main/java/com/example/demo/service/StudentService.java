package com.example.demo.service;

import com.example.demo.dao.Student;
import com.example.demo.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO getStudentById(Long id);



    public Long addNewStudent(StudentDTO studentDTO);

    void deleteStudentById(long id);

    StudentDTO updataStudentById(long id, String name, String email);

    List<Student> getAllStudent();


}
