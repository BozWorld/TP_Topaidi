package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Utilisateur;

public interface IUtilisateurService {
	
	List<Utilisateur> getUtilisateurList();
	
	Utilisateur getUtilisateur(String mail, String code);
	
	void create(Utilisateur u);
}
