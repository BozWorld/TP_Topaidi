package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Utulisateur;

public interface IdeeDao {
	void create(Idee i);
	
	List<Idee> getListIdeeRaw();
	
	List<Idee> getListIdee();
	
	List<Idee> getListBuzz();
	
	List<Idee> getListTop();
	
	List<Utulisateur> getTopUtulisateur();
	
	Utulisateur getUtulisateur(Long id);
	
}
