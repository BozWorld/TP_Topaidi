package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.IdeeDaoImpl;
import fr.epsi.entite.Idee;
import fr.epsi.entite.Utulisateur;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeeService implements IIdeeService {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction utx;
	
	public List<Idee> getIdeeListRaw() {
		IdeeDaoImpl dao =  new IdeeDaoImpl(em, utx);
		return dao.getListIdeeRaw();
	}
	public List<Idee> getIdeeList() {
		IdeeDaoImpl dao =  new IdeeDaoImpl(em, utx);
		return dao.getListIdee();
	}
	
	public List<Idee> getListBuzz() {
		IdeeDaoImpl dao =  new IdeeDaoImpl(em, utx);
		return dao.getListBuzz();
	}
	
	public List<Idee> getListTop() {
		IdeeDaoImpl dao =  new IdeeDaoImpl(em, utx);
		return dao.getListTop();
	}
	
	public List<Utulisateur> getTopUtulisateur() {
		IdeeDaoImpl dao =  new IdeeDaoImpl(em, utx);
		return dao.getTopUtulisateur();
	}
	
	public void create(Idee i) {
		IdeeDaoImpl dao =  new IdeeDaoImpl(em, utx);
		dao.create(i);
	}
}
