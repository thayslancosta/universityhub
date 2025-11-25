package br.com.unifacisa.universityhub.config;

import br.com.unifacisa.universityhub.entities.Course;
import br.com.unifacisa.universityhub.entities.Teacher;
import br.com.unifacisa.universityhub.repositories.CourseRepository;
import br.com.unifacisa.universityhub.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;


//Classe de testes
@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig implements CommandLineRunner {

    //Injeção de dependência via construtor feita com a anotation @RequiredArgsConstructor
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;


    //Método run com persistência de objetos
    @Override
    public void run(String... args) throws Exception {
        Teacher t1 = new Teacher(null, "Maria Brown");
        Teacher t2 = new Teacher(null, "Alex Green");

        teacherRepository.saveAll(Arrays.asList(t1,t2));

        Course c1 = new Course(null,"Java I", Instant.parse("2025-02-01T09:00:00Z"), t1);
        Course c2 = new Course(null,"Java II", Instant.parse("2025-02-01T09:00:00Z"), t2);
        Course c3 = new Course(null,"GEN AI", Instant.parse("2025-02-01T09:00:00Z"), t2);

        courseRepository.saveAll(Arrays.asList(c1,c2,c3));
    }

}
