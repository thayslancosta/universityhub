package br.com.unifacisa.universityhub.controllers;

import br.com.unifacisa.universityhub.entities.StudentCard;
import br.com.unifacisa.universityhub.services.StudentCardService;
import br.com.unifacisa.universityhub.services.StudentService;
import org.hibernate.tool.schema.internal.StandardUserDefinedTypeExporter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/studentcards")
public class StudentCardController {

    private final StudentCardService service;

    public StudentCardController(StudentCardService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<StudentCard>> listStudentCards(){
        List<StudentCard> list = service.listStudentCards();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value="{id}")
    public ResponseEntity<StudentCard> findStudentCardById(@PathVariable Long id){
        StudentCard studentCard = service.findStudentCardById(id);
        return ResponseEntity.ok(studentCard);
    }

    @PostMapping
    public ResponseEntity<StudentCard> createStudentCard(@RequestBody StudentCard studentCard){
        studentCard = service.saveStudentCard(studentCard);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studentCard).toUri();
        return ResponseEntity.created(uri).body(studentCard);
    }


}
