package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Idee;
import fr.epsi.entite.Vote;

public interface LikeDao {
	void create(Vote l);
	
	List<Vote> getLikeList();
}
