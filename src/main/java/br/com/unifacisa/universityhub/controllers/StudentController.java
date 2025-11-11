package br.com.unifacisa.universityhub.controllers;

import br.com.unifacisa.universityhub.entities.Student;
import br.com.unifacisa.universityhub.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/students")
public class StudentController {

    private final StudentService service;

    //Injeção de dependência via construtor da classe service
    public StudentController(StudentService service) {
        this.service = service;
    }
    //Requisição GET para listar todos os objetos da classe
    @GetMapping
    public ResponseEntity<List<Student>> listStudents(){
        List<Student> list = service.listStudents();
        return ResponseEntity.ok(list);
    }
    //Requisição GET para encontrar objeto pelo ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id){
        Student student = service.findStudentById(id);
        return ResponseEntity.ok(student);
    }
    //Requisição POST para criação de objeto
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        student = service.saveStudent(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                             .buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(student);

    }

}
