package com.inti.TD1Rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor @ RequiredArgsConstructor
public class Ecole 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom;
	private @NonNull String adresse;
	private @NonNull int cp;
	private @NonNull String ville;
	
	@OneToMany(mappedBy = "ecole")
	List<Etudiant> listeEtudiant;
	
}
