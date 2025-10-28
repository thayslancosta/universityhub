package br.com.unifacisa.universityhub.services;

import br.com.unifacisa.universityhub.entities.Student;
import br.com.unifacisa.universityhub.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository repository;

    public StudentService (StudentRepository rep) {
        this.repository = rep;
    }

    public List<Student> listStudents() {
        return repository.findAll();
    }

    public Student findStudentById (Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found!"));
    }

    @Transactional
    public Student saveStudent (Student student) {
        return repository.save(student);
    }

    @Transactional
    public void deleteStudentById (Long id){
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Student not found!");
        }
        repository.deleteById(id);
    }
}
