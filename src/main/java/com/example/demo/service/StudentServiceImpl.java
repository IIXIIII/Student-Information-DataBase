package com.example.demo.service;

import com.example.demo.converter.StudentConverter;
import com.example.demo.dao.Student;
import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student =  studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudentDTO(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        List<Student> studentList = studentRepository.findByEmail(studentDTO.getEmail());
        if(!CollectionUtils.isEmpty(studentList)){
            throw new IllegalStateException("email"+studentDTO.getEmail()+" already been used ! ");
        }

        Student student = studentRepository.save(StudentConverter.convertStudent(studentDTO));

        return student.getId();
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id:" + id +"DNE"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDTO updataStudentById(long id, String name, String email) {
        Student studentInDB = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id:" + id +"DNE"));
        if (StringUtils.hasLength(name) && !studentInDB.getName().equals(name)) {
            studentInDB.setName(name);
        }
        if(StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)){
            studentInDB.setEmail(email);
        }
        Student student = studentRepository.save(studentInDB);
        return StudentConverter.convertStudentDTO(student);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = studentRepository.findAll();
//        return (StudentDTO) students.stream()
//          .map(StudentConverter::convertStudentDTO)
//          .collect(Collectors.toList());
        return students;
    }

}
