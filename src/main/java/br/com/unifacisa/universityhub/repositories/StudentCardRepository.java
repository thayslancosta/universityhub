package br.com.unifacisa.universityhub.repositories;

import br.com.unifacisa.universityhub.entities.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCardRepository extends JpaRepository <StudentCard, Long> {
}
