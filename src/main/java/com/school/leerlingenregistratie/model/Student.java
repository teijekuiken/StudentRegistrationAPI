package com.school.leerlingenregistratie.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Student {

    private UUID StudentID;
    private String studentFirstName;
    private String studentLastName;
    private String klas;

    public Student(@JsonProperty("id") UUID studentID,
                   @JsonProperty("firstName") String studentFirstName,
                   @JsonProperty("lastName") String studentLastName,
                   @JsonProperty("klas") String klas) {
        this.StudentID = studentID;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.klas = klas;
    }

    public UUID getStudentID() {
        return StudentID;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }
}
