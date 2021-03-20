package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Commentaire;
import fr.epsi.entite.Utilisateur;

public interface ICommentaireService {
	List<Commentaire> getCommentaireList();
}
