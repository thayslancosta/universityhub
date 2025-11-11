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
@ToString(exclude = "teacher")
@EqualsAndHashCode
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    //ID da classe gerado automaticamente pelo BD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    //Relacionamento ManyToOne com carregamento de dados sob demanda lado opcional que contém a FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;
}
