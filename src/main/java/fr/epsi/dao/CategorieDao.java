package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Categorie;
import fr.epsi.entite.Idee;

public interface CategorieDao {
	void create(Categorie c);
	
	List<Categorie> getAllCategorie();
}
