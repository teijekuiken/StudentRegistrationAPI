package com.school.leerlingenregistratie.dao;

import com.school.leerlingenregistratie.model.Student;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("StudentDao")
public class StudentDataAccessService implements StudentDao {

    private static List<Student> database = new ArrayList<>();

    @Override
    public int insertStudent(UUID id, Student student) {
        database.add(new Student(id, student.getStudentFirstName(), student.getStudentLastName()));
        return 1;
    }

    @Override
    public Optional<Student> selectStudentById(UUID id) {
        return database.stream()
                .filter(student -> student.getStudentID().equals(id))
                .findFirst();
    }

    @Override
    public List<Student> selectAllStudents() {
        return database;
    }

    @Override
    public int deleteStudentId(UUID id) {
        Optional<Student> student = selectStudentById(id);

        if(student.isEmpty()){
            return 0;
        }
        database.remove(student.get());
        return 1;
    }

    @Override
    public int updateStudent(UUID id, Student student) {
        return selectStudentById(id)
                .map(s -> {
                    int indexOfStudentToDelete = database.indexOf(student);
                    if(indexOfStudentToDelete >= 0){
                        database.set(indexOfStudentToDelete, student);
                        return 1;
                    }
                    return 1;
                })
                .orElse(0);
    }
}
