package in.toin.studentCourse.controller;

import in.toin.studentCourse.entity.Course;

import in.toin.studentCourse.entity.Student;
import in.toin.studentCourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/course")
public class CourseController {
    
    @Autowired
    private CourseRepository repository;
    
    // insert new course into database
    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return repository.save(course);
    }
    
    // fetch all course list from database
    @GetMapping("/all")
    public Iterable<Course> allCourse() {
        return repository.findAll();
    }
    
    // fetch specific course by their ID
    @GetMapping("/{id}")
    public Optional<Course> courseById(@PathVariable("id") int id) {
        return repository.findById(id);
    }
    
//    @PutMapping("/{id}/addStudent")
//    public Student addCourseStudent(@RequestBody Student student) {
//        addStudent(student);
//    }
//
    // update existing course
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return repository.save(course);
    }
    
    // delete course from database
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") int id) {
        repository.deleteById(id);
    }
}
