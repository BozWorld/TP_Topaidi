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
import fr.epsi.entite.Idee;

public class IdeeDaoImpl implements IdeeDao{
	EntityManager em;
	UserTransaction utx;
	public IdeeDaoImpl(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	public void create(Idee i) {
			try {
				utx.begin();
				
			} catch (NotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			em.persist(i);
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
	
	public List<Idee> getListIdee() {
		return em.createQuery("select i from Idee i order by ((i.nbTop / (i.nbDeFlop + i.nbDeTop)) * 100) desc, i.nbVotes desc, i.date asc", Idee.class)
				.setMaxResults(3) 
				.getResultList();
	}

	public List<Idee> getListBuzz() {
		return em.createQuery("select i from Idee i order by (i.nbDeFlop + i.nbDeTop) desc", Idee.class)
				 .setMaxResults(3)
				 .getResultList();
	}
	
	public List<Idee> getListTop() {
		return em.createQuery("select i from Idee i order by i.nbDeTop desc", Idee.class)
				.setMaxResults(3) 
				.getResultList();
	}
	
	public Utulisateur getUtulisateur(Long id) {
		return em.createQuery("select u from Utulisateur u where u.id :=id", Utulisateur.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public List<Utulisateur> getTopUtulisateur(){
		return em.createQuery("select i.utulisateur from idee i order by i.utulisateur", Utulisateur.class)
				.setMaxResults(3)
				.getResultList();
	}
		
	}