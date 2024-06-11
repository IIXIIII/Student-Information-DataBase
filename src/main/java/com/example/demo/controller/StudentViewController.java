package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students/view")
public class StudentViewController {

    @Autowired
    private StudentService studentService;

    /**
     * display all of the student information
     * http://localhost:8080/students/view
     */
    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    /**
     * add student information //show add student form
     * need Name and Email
     * http://localhost:8080/students/view/add
     */
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "add-student";
    }

    /**
     *
     * @param student
     * @return
     */
    @PostMapping
    public String addStudent(@ModelAttribute StudentDTO student) {
        studentService.addNewStudent(student);
        return "redirect:/students/view";
    }

    /**
     * update student
     * http://localhost:8080/students/view/edit/1
     */
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        StudentDTO student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update-student";
    }

    /**
     *
     * @param id
     * @param student
     * @return
     */
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long id, @ModelAttribute StudentDTO student) {
        studentService.updataStudentById(id, student.getName(), student.getEmail());
        return "redirect:/students";
    }

    /**
     *  delete student
     *  http://localhost:8080/students/view/delete/id
     */
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students/view";
    }
}
