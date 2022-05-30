package com.inti.TD1Rest.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.NonNull;

public class Professeur 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom; 
	private @NonNull String prenom;
	private @NonNull Double salaire;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "idProfesseur"), 
	inverseJoinColumns = @JoinColumn(name="idEtudiant"))
	List<Etudiant> listeEtudiants;

}
