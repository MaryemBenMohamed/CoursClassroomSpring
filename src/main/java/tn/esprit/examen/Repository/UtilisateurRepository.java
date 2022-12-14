package tn.esprit.examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.Entities.Niveau;
import tn.esprit.examen.Entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur , Integer> {

    Integer countByClasseNiveau(Niveau niveau);
}
