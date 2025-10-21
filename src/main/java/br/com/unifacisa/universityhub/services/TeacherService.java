package br.com.unifacisa.universityhub.services;

import br.com.unifacisa.universityhub.entities.Teacher;
import br.com.unifacisa.universityhub.repositories.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public List<Teacher> listTeachers(){
        return repository.findAll();
    }

    public Teacher findTeacherById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
    }

    @Transactional
    public void saveTeacher(Teacher teacher){
        repository.save(teacher);
    }

    @Transactional
    public void deleteTeacherById(Long id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Teacher not found!");
        }
        repository.deleteById(id);
    }
}
