package com.example.Tutorial02;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
 @Autowired
 private StudentRepository studentRepository;
 
 //save student in database
 
@Override
 public Student saveStudent(Student student){
    return studentRepository.save(student);
 }

 //get all student from db
    @Override
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    //get student using id
    @Override
    public Student getStudentById(long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }else{
            throw new RuntimeException();
        }
    }

    //update student
    @Override
    public Student updateStudent(Student student,long id){
        Student existingStudent=studentRepository.findById(id).orElseThrow(()-> new RuntimeException());

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        //save
        studentRepository.save(existingStudent);
        return existingStudent;
    }
 
    //delete employee
    @Override
    public void deleteStudent(long id){
        //check
        studentRepository.findById(id).orElseThrow(()->new RuntimeException());
        //delete
        studentRepository.deleteById(id);
    }
   
}
