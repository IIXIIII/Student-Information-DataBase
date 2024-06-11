package com.example.demo.controller;

//import ch.qos.logback.core.model.Model;
import com.example.demo.Response;
import com.example.demo.dao.Student;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentController {

    @Autowired
    private StudentService studentService;

    /**
     * use Get
     * look up student by id
     * /student/id
     *
     * @param id - the id of the student
     * @return Response
     */
    @GetMapping("/students/{id}")
    public Response<StudentDTO> getStudentById(@PathVariable long id ){
        return Response.newSuccess( studentService.getStudentById(id));
    }

    /**
     * use Post
     * create and add new student
     * /student
     * raw
     *
     * @param studentDTO - include the detail of the student
     * @return response
     */
    @PostMapping("/students")
    public Response<Long> addNewStudent(@RequestBody StudentDTO studentDTO){
        return Response.newSuccess(studentService.addNewStudent(studentDTO));
    }

    /**
     * use Delete
     * delete student from db
     * /student/id
     *
     *
     * @param id - id of the student
     */
    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable long id){
        studentService.deleteStudentById(id);
    }

    /**
     * use PUT
     * change student detail
     * /student/id
     * form-data
     *
     * @param id - id of the stu
     * @param name - optional
     * @param email - optional
     * @return Response
     */
    @PutMapping("/students/{id}")
    public Response<StudentDTO> updataStudentById(@PathVariable long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        return Response.newSuccess(studentService.updataStudentById(id, name, email));
    }

    /**
     * use Get
     * output all of the student in the db
     * /student/all
     *
     * @return all the student
     */
    @GetMapping("/students/all")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }


}
