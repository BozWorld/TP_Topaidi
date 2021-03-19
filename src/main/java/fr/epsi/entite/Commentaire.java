package fr.epsi.entite;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Commentaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Utulisateur utulisateur;
	
	private Date date;
	
	@ManyToOne
	private Idee idee;
	
	private String description;
	
	public Utulisateur getUtulisateur() {
		return utulisateur;
	}
	
	public void setUtulisateur(Utulisateur utulisateur) {
		this.utulisateur = utulisateur;
	}
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public Idee getIdee() {
		return idee;
	}
	
	public void setIdee(Idee idee) {
		this.idee = idee;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
