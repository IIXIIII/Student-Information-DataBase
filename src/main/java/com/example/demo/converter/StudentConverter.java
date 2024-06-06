package com.example.demo.converter;

import com.example.demo.dao.Student;
import com.example.demo.dto.StudentDTO;

public class StudentConverter {

    /**
     * convert student to studentDTO
     * @param student - the stu that we want to canvert into dto version
     * @return - dto version of stu
     */
    public static StudentDTO convertStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        return studentDTO;
    }

    /**
     * convert StudentDTO to student
     * @param studentDTO - dto
     * @return - stu
     */
    public static Student convertStudent(StudentDTO studentDTO){
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        return student;
    }
}
