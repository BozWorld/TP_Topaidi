package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Vote;
import fr.epsi.entite.Utilisateur;

public interface ILikeService {
	List<Vote> getLikeList();
}
