package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Utulisateur;

public interface IIdeeService {
	
	List<Idee> getIdeeListRaw();
	
	List<Idee> getIdeeList();
	
	List<Idee> getListBuzz();
	
	List<Idee> getListTop();
	
	List<Utulisateur> getTopUtulisateur();
	
	void create(Idee i);
}
