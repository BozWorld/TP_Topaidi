package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.UtilisateurDaoImpl;
import fr.epsi.entite.Utilisateur;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UtilisateurService implements IUtilisateurService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public List<Utilisateur> getUtilisateurList() {
		UtilisateurDaoImpl dao =  new UtilisateurDaoImpl(em, utx);
		return dao.getListUtilisateur();
	}
	
	public void create(Utilisateur u) {
		UtilisateurDaoImpl dao =  new UtilisateurDaoImpl(em, utx);
		dao.create(u);
	}

	@Override
	public Utilisateur getUtilisateur(String mail, String code) {
		UtilisateurDaoImpl dao =  new UtilisateurDaoImpl(em, utx);
		return dao.getUtilisateur(code, mail);
	}
}
