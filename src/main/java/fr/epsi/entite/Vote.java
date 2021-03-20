 package fr.epsi.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Utilisateur utilisateur;
	
	@ManyToOne
	private Idee idee;
	
	private vote typeVote;
	
	public enum vote{
		
		top,flop
	};
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Idee getIdee() {
		return idee;
	}
	
	public void setIdee(Idee idee) {
		this.idee = idee;
	}
	
	public vote getVote()
	{
		return typeVote;
	}
	
	public void setVote(vote l) {
		this.typeVote = l;
	}
}

