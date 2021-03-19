package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Categorie;

public interface ICategorieService {
	
	void create(Categorie c);
	
	List<Categorie> getAllCategorie();
}
