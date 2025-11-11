package br.com.unifacisa.universityhub.config;

import br.com.unifacisa.universityhub.entities.Course;
import br.com.unifacisa.universityhub.entities.Teacher;
import br.com.unifacisa.universityhub.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final TeacherRepository repository;

    public TestConfig(TeacherRepository teacherRepository){
        this.repository = teacherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Teacher t1 = new Teacher(null, "Maria Brown");
        Teacher t2 = new Teacher(null, "Alex Green");

        repository.saveAll(Arrays.asList(t1,t2));
    }
}
