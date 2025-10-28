package br.com.unifacisa.universityhub.controllers;

import br.com.unifacisa.universityhub.entities.Course;
import br.com.unifacisa.universityhub.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/courses")
public class CourseController {

    private final CourseService service;

    public CourseController (CourseService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity <List<Course>> listCourses () {
        List<Course> list = service.listCourses();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> findCourseById (@PathVariable Long id){
        Course course = service.findCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse (@RequestBody Course course){
        course = service.saveCourse(course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(course);
    }
}
