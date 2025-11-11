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

    //Injeção de dependência via construtor da classe service
    public CourseController (CourseService service){
        this.service = service;
    }

    //Requisição GET para listar todos os objetos da classe
    @GetMapping
    public ResponseEntity <List<Course>> listCourses () {
        List<Course> list = service.listCourses();
        return ResponseEntity.ok(list);
    }
    //Requisição GET para encontrar objeto pelo ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> findCourseById (@PathVariable Long id){
        Course course = service.findCourseById(id);
        return ResponseEntity.ok(course);
    }
    //Requisição POST para criação de objeto
    @PostMapping
    public ResponseEntity<Course> createCourse (@RequestBody Course course){
        course = service.saveCourse(course);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(course);
    }
    //Requisição DELETE para deletar objeto pelo ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Long id){
        service.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }
}
