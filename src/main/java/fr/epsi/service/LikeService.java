package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.ejb.TransactionManagementType;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.LikeDaoImpl;
import fr.epsi.entite.Vote;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class LikeService implements ILikeService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;

	public List<Vote> getLikeList() {
		LikeDaoImpl dao =  new LikeDaoImpl(em, utx);
		return dao.getLikeList();
	}
	
	public void create(Vote l) {
		LikeDaoImpl dao =  new LikeDaoImpl(em, utx);
		dao.create(l);
	}
}
