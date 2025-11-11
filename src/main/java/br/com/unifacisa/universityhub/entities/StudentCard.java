package br.com.unifacisa.universityhub.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "student")
@EqualsAndHashCode(exclude = "student")
public class StudentCard implements Serializable {

    private static final long serialVersionUID = 1L;

    //ID da classe gerado automaticamente pelo BD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    //Relacionamento OneToOne com Student (classe pai)
    @OneToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;
}
