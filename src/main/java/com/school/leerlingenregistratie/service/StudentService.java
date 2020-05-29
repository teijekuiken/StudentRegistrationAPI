package com.school.leerlingenregistratie.service;

import com.school.leerlingenregistratie.dao.StudentDao;
import com.school.leerlingenregistratie.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("StudentDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addStudent(Student student){
        return studentDao.insertStudent(student);
    }

    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }

    public Optional<Student> getStudentById(UUID id){
        return studentDao.selectStudentById(id);
    }

    public int deleteStudentId(UUID id){
        return studentDao.deleteStudentId(id);
    }

    public int updateStudent(UUID id, Student studentToUpdate){
        return studentDao.updateStudent(id, studentToUpdate);
    }

}
