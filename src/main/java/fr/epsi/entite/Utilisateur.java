package fr.epsi.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Commentaire> commentaireList;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Vote> voteList;
	
	@OneToMany(mappedBy = "utilisateur")
	private List<Idee> ideeList;
	
	private String mail;
	
	private String pseudo;
	
	private String code;

	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public List<Commentaire> getCommentaireList(){
		return commentaireList;
	}
	
	public void setCommentaireList(List<Commentaire> commentaireList) {
		this.commentaireList = commentaireList;
	}
	
	public List<Vote> getVoteList() {
		return this.voteList;
	}
	
	public void setLikeList(List<Vote> voteList) {
		this.voteList = voteList;
	}
	public List<Idee> getIdeeList() {
		return this.ideeList;
	}
	
	public void setIdeeList(List<Idee> ideeList) {
		this.ideeList = ideeList;
	}
	
}
