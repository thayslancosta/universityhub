package br.com.unifacisa.universityhub.services;

import br.com.unifacisa.universityhub.entities.StudentCard;
import br.com.unifacisa.universityhub.repositories.StudentCardRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentCardService {

    private final StudentCardRepository repository;

    public StudentCardService(StudentCardRepository studentCardRepository) {
        this.repository = studentCardRepository;
    }

    public List<StudentCard> listStudentCards() {
        return repository.findAll();
    }

    public StudentCard findStudentCardById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student card not found!"));
    }

    @Transactional
    public StudentCard saveStudentCard(StudentCard studentCard) {
        return repository.save(studentCard);
    }

    @Transactional
    public void deleteStudentCardById(Long id) {
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Student Card not found!");
        }
        repository.deleteById(id);
    }


}
