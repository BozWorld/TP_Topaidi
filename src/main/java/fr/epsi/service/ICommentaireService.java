package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Commentaire;
import fr.epsi.entite.Utulisateur;

public interface ICommentaireService {
	List<Commentaire> getCommentaireList();
}
