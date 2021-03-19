package fr.epsi.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Commentaire;
import fr.epsi.entite.Commentaire;
import fr.epsi.entite.Vote;
import fr.epsi.entite.Commentaire;

public class CommentaireDaoImpl implements CommentaireDao{
	EntityManager em;
	UserTransaction utx;
	public CommentaireDaoImpl(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	public void create(Commentaire c) {
			try {
				utx.begin();
				Commentaire commentaire = new Commentaire();
				commentaire.setDescription(c.getDescription());
				
			} catch (NotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			em.persist(c);
			try {
				utx.commit();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicMixedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	public List<Commentaire> getCommentaireList() {
		return em.createQuery("select c from Commentaire c order by c.nom asc", Commentaire.class)
				 .getResultList();
	}
		
	}