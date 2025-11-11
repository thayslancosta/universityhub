package br.com.unifacisa.universityhub.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = "studentCard")
@ToString(exclude = "studentCard")
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    //ID da classe gerado automaticamente pelo BD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    //Relacionamento OneToOne com StudentCard (lado opcional)
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private StudentCard studentCard;
}


