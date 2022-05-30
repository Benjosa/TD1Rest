package com.inti.TD1Rest.Controller;

import java.util.List;

import com.inti.TD1Rest.Repository.UtilisateurRepository;
import com.inti.TD1Rest.model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController 
{
	@Autowired
	UtilisateurRepository ur;
	
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
	
	
	
}
