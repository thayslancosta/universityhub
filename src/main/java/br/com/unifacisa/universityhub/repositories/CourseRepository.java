package br.com.unifacisa.universityhub.repositories;

import br.com.unifacisa.universityhub.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository <Course, Long> {
}
