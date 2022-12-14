package tn.esprit.examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.Entities.CoursClassroom;
import tn.esprit.examen.Entities.Niveau;
import tn.esprit.examen.Entities.Specialite;

public interface CoursClassroomRepository extends JpaRepository<CoursClassroom , Integer> {
    CoursClassroom findBySpecialiteAndClasseNiveau(Specialite specialite, Niveau niveau);

}
