package com.app.controller;

import com.app.modal.Student;
import com.app.modal.StudentDTO;
import com.app.modal.StudentReq;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

@Component
public class StudentsController {

    @Autowired
    private StudentService studentsService;

    @MutationMapping("createStudent")  // Mutation to register a new student
    public StudentDTO registerStudent(@Argument StudentReq studentReq) {
        // Save and return the registered student
        return studentsService.createStudent(studentReq);
    }

    @QueryMapping("getStudentById")  // Query to get a student by ID
    public StudentDTO getStudentById(@Argument Long id) {
        // Retrieve the student using the service layer
        return studentsService.getStudentById(id);
    }

    @QueryMapping("getAllStudents")  // Query to get all students
    public List<StudentDTO> getAllStudents() {
        // Retrieve and return all students
        return studentsService.getAllStudents();
    }

    @MutationMapping("updateStudent")  // Mutation to update a student
    public StudentDTO updateStudent(@Argument Long id, @Argument StudentReq studentReq) {
        // Update and return the student based on provided ID and request details
        return studentsService.updateStudent(id, studentReq);
    }

    @MutationMapping("deleteStudent")  // Mutation to delete a student
    public Boolean deleteStudent(@Argument Long id) {
        // Delete the student and return true if successful
        return studentsService.deleteStudent(id);
    }
}

