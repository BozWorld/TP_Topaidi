package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.ejb.TransactionManagementType;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.CategorieDaoImpl;
import fr.epsi.dao.CommentaireDaoImpl;
import fr.epsi.entite.Categorie;
import fr.epsi.entite.Commentaire;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CategorieService implements ICategorieService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;


	@Override
	public void create(Categorie c) {
		CategorieDaoImpl dao = new CategorieDaoImpl(em,utx);
	    dao.create(c);
	}

	@Override
	public List<Categorie> getAllCategorie() {
		CategorieDaoImpl dao = new CategorieDaoImpl(em,utx);
		return dao.getAllCategorie();
	}
}
