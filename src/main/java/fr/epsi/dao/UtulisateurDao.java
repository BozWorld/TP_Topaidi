package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Utulisateur;

public interface UtulisateurDao {
	void create(Utulisateur u);
	
	List<Utulisateur> getListUtulisateur();
	
	List<Utulisateur> getTopUtulisateur();
	
	Utulisateur getUtulisateur( String mail,String code);
}
