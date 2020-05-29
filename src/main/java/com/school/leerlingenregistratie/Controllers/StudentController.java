package com.school.leerlingenregistratie.Controllers;

import com.school.leerlingenregistratie.model.Student;
import com.school.leerlingenregistratie.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/student")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") UUID id){
        return studentService.getStudentById(id)
                .orElse(null);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") UUID id){
        studentService.deleteStudentId(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") UUID id, @RequestBody Student studentToUpdate){
        studentService.updateStudent(id, studentToUpdate);
    }


}
