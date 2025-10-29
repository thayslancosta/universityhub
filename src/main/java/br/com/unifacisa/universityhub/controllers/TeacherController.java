package br.com.unifacisa.universityhub.controllers;

import br.com.unifacisa.universityhub.entities.Teacher;
import br.com.unifacisa.universityhub.services.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/teachers")
public class TeacherController {

    private final TeacherService service;

    public TeacherController (TeacherService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> listTeachers(){
        List<Teacher> list = service.listTeachers();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value="/id")
    public ResponseEntity<Teacher> findTeacherById(@PathVariable Long id){
        Teacher teacher = service.findTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher (@RequestBody Teacher teacher){
        teacher = service.saveTeacher(teacher);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(teacher.getId()).toUri();
        return ResponseEntity.created(uri).body(teacher);
    }
}
