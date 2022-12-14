package tn.esprit.examen.Entities;

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
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) //on peux pas modifier l'id
     Integer idUtilisateur;
     String nom;
     String prenom;
     String password;

     @ManyToOne
     Classe classe;
     @OneToMany(mappedBy = "utilisateur")
     Set<Classe> classes=new HashSet<>();

     @OneToMany(mappedBy = "utilisateur")
     Set<Utilisateur> utilisateurs=new HashSet<>();
     @ManyToOne
    Utilisateur utilisateur;


}
