package com.school.leerlingenregistratie.dao;

import com.school.leerlingenregistratie.model.Student;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    int insertStudent(UUID id, Student student);

    default int insertStudent(Student student){
        UUID id = UUID.randomUUID();
        return insertStudent(id, student);
    }

    Optional<Student>  selectStudentById(UUID id);

    List<Student> selectAllStudents();

    int deleteStudentId(UUID id);

    int updateStudent(UUID id, Student student);
}
