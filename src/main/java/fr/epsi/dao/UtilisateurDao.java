package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Utilisateur;

public interface UtilisateurDao {
	void create(Utilisateur u);
	
	List<Utilisateur> getListUtilisateur();
	
	List<Utilisateur> getTopUtilisateur();
	
	Utilisateur getUtilisateur( String mail,String code);
}
