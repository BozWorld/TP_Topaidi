package fr.epsi.entite;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Idee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Utulisateur utulisateur;
	
	@OneToMany(mappedBy = "idee")
	private List<Commentaire> commentaire;

	@OneToMany(mappedBy = "idee")
	private List<Vote> voteList;
	
	@ManyToOne
	private Categorie categorie;
	
	private String photo;
	
	private String description;
	
	private Date date;
	
	private int nbDeFlop;
	
	private int nbDeTop;
	
	private int totalVote;
	
	
	
	public Utulisateur getUtulisateur() {
		return utulisateur;
	}
	
	public void setUtulisateur(Utulisateur utulisateur) {
		this.utulisateur = utulisateur;
	}
	
	public List<Commentaire> getCommentaireList(){
		return commentaire;
	}
	
	public void setCommentaireList(List<Commentaire> commentaire){
		this.commentaire = commentaire;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<Vote> getVoteList(){
		return voteList;
	}
	
	public void setVote(Vote v) {
		this.voteList.add(v); 
		
		if(v.getVote().equals("TOP")) {
			totalVote +=1;
			nbDeTop += 1;
		}
		else {
			totalVote +=1;
			nbDeFlop += 1;
		}
	}
	
}
