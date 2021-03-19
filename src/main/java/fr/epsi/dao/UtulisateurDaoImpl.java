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
import fr.epsi.entite.Idee;
import fr.epsi.entite.Vote;
import fr.epsi.entite.Utulisateur;

public class UtulisateurDaoImpl implements UtulisateurDao{
	EntityManager em;
	UserTransaction utx;
	public UtulisateurDaoImpl(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	public void create(Utulisateur u) {
			try {
				utx.begin();
				Utulisateur newUtulisateur = new Utulisateur();
				newUtulisateur.setMail(u.getMail());
			} catch (NotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			em.persist(u);
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

	public List<Utulisateur> getListUtulisateur() {
		return em.createQuery("select u from Utulisateur u order by u.nom asc", Utulisateur.class)
				 .setMaxResults(3)
				 .getResultList();
	}
	
	public List<Utulisateur> getTopUtulisateur() {
		return em.createQuery("select u from Utulisateur u order by COUNT(u.ideeList) asc", Utulisateur.class)
				 .getResultList();
	}
	@Override
	public Utulisateur getUtulisateur(String code, String mail) {
		return em.createQuery("Select u from Utulisateur u WHERE u.mail :=mail AND u.code :=code",Utulisateur.class)
				.setParameter("mail", mail)
				.setParameter("code", code)
				.getSingleResult();
	}
		
	}