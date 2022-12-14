package tn.esprit.examen.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CoursClassroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Integer idCours;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    String nom;
    Integer nbheures;
    boolean archive;

    @JsonIgnore
    @ManyToOne
    Classe classe;
}
