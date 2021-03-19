package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.UtulisateurDaoImpl;
import fr.epsi.entite.Utulisateur;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UtulisateurService implements IUtulisateurService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public List<Utulisateur> getUtulisateurList() {
		UtulisateurDaoImpl dao =  new UtulisateurDaoImpl(em, utx);
		return dao.getListUtulisateur();
	}
	
	public void create(Utulisateur u) {
		UtulisateurDaoImpl dao =  new UtulisateurDaoImpl(em, utx);
		dao.create(u);
	}

	@Override
	public Utulisateur getUtululisateur(String mail, String code) {
		UtulisateurDaoImpl dao =  new UtulisateurDaoImpl(em, utx);
		return dao.getUtulisateur(code, mail);
	}
}
