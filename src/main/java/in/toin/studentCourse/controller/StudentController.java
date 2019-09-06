package in.toin.studentCourse.controller;

import in.toin.studentCourse.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import in.toin.studentCourse.entity.Student;
import in.toin.studentCourse.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentRepository repository;
    
    // insert new Student into database
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }
    
    // fetch all student list from database
    @GetMapping("/all")
    public Iterable<Student> allStudent() {
        return repository.findAll();
    }
    
    // fetch specific student by their ID
    @GetMapping("/{id}")
    public Optional<Student> studentById(@PathVariable("id") int id) {
        return repository.findById(id);
    }
    
//    @GetMapping("/{id}/getCourses")
//    public Iterable<Course> getStudentCourses(@PathVariable int id) {
//        return
//    }
//
//    @PutMapping("/{id}/addCourse")
//    public Course addStudentCourse(@RequestBody Course course, @PathVariable int id) {
//        return addCourse(course);
//    }
    
    // update existing student
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return repository.save(student);
    }
    
    // delete student from database
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        repository.deleteById(id);
    }
}