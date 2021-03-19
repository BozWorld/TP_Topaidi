package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.ejb.TransactionManagementType;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.CommentaireDaoImpl;
import fr.epsi.entite.Commentaire;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CommentaireService implements ICommentaireService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public List<Commentaire> getCommentaireList() {
		CommentaireDaoImpl dao =  new CommentaireDaoImpl(em, utx);
		return dao.getCommentaireList();
	}
	
	public void create(Commentaire c) {
		CommentaireDaoImpl dao =  new CommentaireDaoImpl(em, utx);
		dao.create(c);
	}
}
