package br.com.unifacisa.universityhub.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "courses")
@EqualsAndHashCode(exclude = "courses")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    //ID da classe gerado automaticamente pelo BD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //Relacionamento OneToMany lado principal
    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<Course> courses;
}
