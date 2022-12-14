package tn.esprit.examen.ServiceExam;

import tn.esprit.examen.Entities.*;

public interface IServiceExam {

    public Utilisateur ajouterUtilisateur (Utilisateur utilisateur);

    public Classe ajouterClasse (Classe c);

    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer codeClasse);

    public void affecterUtilisateurClasse (Integer idUtilisateur, Integer codeClasse);

    public Integer nbUtilisateursParNiveau(Niveau nv);

    public void archiverCoursClassrooms();

    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);

}
