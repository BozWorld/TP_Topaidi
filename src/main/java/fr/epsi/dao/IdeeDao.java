package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Utilisateur;

public interface IdeeDao {
	void create(Idee i);
	
	List<Idee> getListIdeeRaw();
	
	List<Idee> getListIdee();
	
	List<Idee> getListBuzz();
	
	List<Idee> getListTop();
	
	List<Utilisateur> getTopUtilisateur();
	
	Utilisateur getUtilisateur(Long id);
	
}
