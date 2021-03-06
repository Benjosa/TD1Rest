package com.inti.TD1Rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Professeur 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom; 
	private @NonNull String prenom;
	private @NonNull Double salaire;
	
	@ManyToMany
	@JoinTable(name = "Professeur_Etudiant", joinColumns = @JoinColumn(name = "idProfesseur"), 
	inverseJoinColumns = @JoinColumn(name="idEtudiant"))
	@JsonIgnore
	List<Etudiant> listeEtudiants;
	
	@ManyToMany
	@JoinTable(name = "Ecole_Professeur", joinColumns = @JoinColumn(name = "idProfesseur"), 
	inverseJoinColumns = @JoinColumn(name = "idEcole"))
	@JsonIgnore
	List<Ecole> listeEcoles;

	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + "]";
	}
	
	

}
