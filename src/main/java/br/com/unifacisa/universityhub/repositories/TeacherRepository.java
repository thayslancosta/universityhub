package br.com.unifacisa.universityhub.repositories;

import br.com.unifacisa.universityhub.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository <Teacher, Long> {
}
