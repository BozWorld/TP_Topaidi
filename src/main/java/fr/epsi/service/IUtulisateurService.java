package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Utulisateur;

public interface IUtulisateurService {
	
	List<Utulisateur> getUtulisateurList();
	
	Utulisateur getUtululisateur(String mail, String code);
	
	void create(Utulisateur u);
}
