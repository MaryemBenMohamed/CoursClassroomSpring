package tn.esprit.examen.ServiceExam;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.Entities.*;
import tn.esprit.examen.Repository.ClasseRepository;
import tn.esprit.examen.Repository.CoursClassroomRepository;
import tn.esprit.examen.Repository.UtilisateurRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceExam implements IServiceExam{

    private UtilisateurRepository utilisateurRepository;
    private ClasseRepository classeRepository;

    private CoursClassroomRepository coursClassroomRepository;
    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Classe ajouterClasse(Classe c) {
        return classeRepository.save(c);
    }

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) {
        Classe classe = classeRepository.findById(codeClasse).orElse(null);
        cc.setClasse(classe);
        return coursClassroomRepository.save(cc);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {

        Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).orElse(null);
        Classe classe = classeRepository.findById(codeClasse).orElse(null);

        utilisateur.setClasse(classe);
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv) {
        return utilisateurRepository.countByClasseNiveau(nv);
    }

    @Scheduled(cron = "*/60 * * * * *")
    @Override
    public void archiverCoursClassrooms() {
        List<CoursClassroom> coursClassrooms = coursClassroomRepository.findAll();
        for (CoursClassroom cc: coursClassrooms ){
            cc.setArchive(true);
            coursClassroomRepository.save(cc);
        }
    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {

        return coursClassroomRepository.findBySpecialiteAndClasseNiveau(sp,nv).getNbheures();
    }
}
