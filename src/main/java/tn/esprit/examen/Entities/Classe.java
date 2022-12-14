package tn.esprit.examen.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Integer codeclasse;
    String titre;
    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @OneToMany(mappedBy = "classe")
    Set<CoursClassroom> coursClassrooms = new HashSet<>();

    @ManyToOne
    Utilisateur utilisateur;




}
