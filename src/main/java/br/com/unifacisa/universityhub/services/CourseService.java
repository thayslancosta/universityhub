package br.com.unifacisa.universityhub.services;

import br.com.unifacisa.universityhub.entities.Course;
import br.com.unifacisa.universityhub.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository){
        this.repository = repository;
    }

    public List<Course> listCourses(){
        return repository.findAll();
    }

    public Course findCourseById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found!"));
    }

    @Transactional
    public Course saveCourse(Course course){
        return repository.save(course);
    }

    @Transactional
    public void deleteCourseById(Long id){
        if(!repository.existsById(id)) {
            throw new EntityNotFoundException("Course not found!");
        }
        repository.deleteById(id);
    }

    public List<Course> listAll () {
        List<Course> list = repository.findAll();
        return list;
    }

}
































