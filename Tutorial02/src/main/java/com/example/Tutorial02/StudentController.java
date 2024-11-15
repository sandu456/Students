package com.example.Tutorial02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new
        ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);

    }

    //getAll Rest Api
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    //Get by Id Rest Api
    @GetMapping("{id}")
    // localhost:8080/api/students/1
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID){
        return new
        ResponseEntity<Student>(studentService.getStudentById(studentID),HttpStatus.OK);

    }

    //update Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody Student student){
        return new
        ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);

    }

    //Delete Rest Api
    @DeleteMapping("{id}")
       public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        //delete student from db
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
       }
    
    
    
}
