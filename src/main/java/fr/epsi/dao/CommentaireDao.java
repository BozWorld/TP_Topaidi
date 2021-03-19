package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Commentaire;

public interface CommentaireDao {
	void create(Commentaire c);
	
	List<Commentaire> getCommentaireList();
}
