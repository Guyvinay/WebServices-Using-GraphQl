package com.app.service;


import com.app.modal.Student;
import com.app.modal.StudentDTO;
import com.app.modal.StudentReq;
import com.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDTO createStudent(StudentReq studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(student.getAge());
        student.setEmail(student.getEmail());
        Student savedStudent = studentRepository.save(student);
        return mapToDTO(savedStudent);
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        return mapToDTO(student);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    public StudentDTO updateStudent(Long id, StudentReq studentDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));

        if((studentDTO.getName())!=null) student.setName(studentDTO.getName());
        if((studentDTO.getAge())!=null) student.setAge(student.getAge());
        if((studentDTO.getEmail())!=null) student.setEmail(student.getEmail());

        Student updatedStudent = studentRepository.save(student);
        return mapToDTO(updatedStudent);
    }

    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id " + id);
        }
        studentRepository.deleteById(id);
        return true;
    }

    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(student.getId(), student.getName(), student.getAge(), student.getEmail());
    }

    private Student mapToEntity(StudentDTO studentDTO) {
        return new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getAge(), studentDTO.getEmail());
    }
}
