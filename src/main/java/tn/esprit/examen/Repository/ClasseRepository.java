package tn.esprit.examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.Entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Integer> {
}
