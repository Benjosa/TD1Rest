package com.inti.TD1Rest.Controller;

import java.util.ArrayList;
import java.util.List;

import com.inti.TD1Rest.Repository.EcoleRepository;
import com.inti.TD1Rest.Repository.ProfesseurRepository;
import com.inti.TD1Rest.Repository.UtilisateurRepository;
import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.model.Professeur;
import com.inti.TD1Rest.model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController 
{
	@Autowired
	UtilisateurRepository ur;
	
	@Autowired
	EcoleRepository ecoleR;
	
	@Autowired
	ProfesseurRepository pr;
	
	
	
	
	@GetMapping("/hello")
	public String hello()
	{
		
		return "Hello World"; // ON RETOURNE LE TEXTE DIRECTEMENT.
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Utilisateur> getAllUsers()
	{
		
		return ur.findAll();
	}
	
	@PostMapping("/save")
	public String saveUtilisateur()
	{
		Utilisateur u = new Utilisateur("login", "login");
		
		ur.save(u);
		
		return "user saved";
		
	}
	
	@PutMapping("/updateEcoleWithProfesseur/{idProf}/{idEcole}")
	public String updateEcoleWithProfesseur(@PathVariable int idProf, @PathVariable int idEcole)
	{
		 Ecole ecole = ecoleR.getReferenceById(idEcole);
		 
		 Professeur prof = pr.getReferenceById(idProf);
		 
		 List<Professeur> listeProfesseurs = new ArrayList<Professeur>();
		 
		 listeProfesseurs.add(prof);
		 
		 ecole.setListeProfesseurs(listeProfesseurs);
		 
		 ecoleR.save(ecole);
		
		return "The school :" + ecole + " has been add to " + prof + " !";
	}
	
	
	
	
}
