package com.inti.TD1Rest.Controller;

import java.util.List;

import com.inti.TD1Rest.Repository.EcoleRepository;
import com.inti.TD1Rest.model.Ecole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoleController 
{
	@Autowired
	EcoleRepository er;
	
	@PostMapping("/addEcole")
	public ResponseEntity<Ecole> saveEcole(@RequestBody Ecole ecole)
	{
		return new ResponseEntity<Ecole>(er.save(ecole),HttpStatus.CREATED);
	}
	
	@GetMapping("/allEcole")
	public ResponseEntity<List<Ecole>> getAllEcole()
	{
		
		return new ResponseEntity<List<Ecole>>(er.findAll(),HttpStatus.OK);
	}
	
	@PutMapping("/updateEcole/{id}")
	public String updateEcole(@RequestBody Ecole ecole, @PathVariable int id)
	{
		Ecole e1 = er.getReferenceById(id);
		
		if(!e1.getAdresse().equals(ecole.getAdresse()) && ecole.getAdresse() != null)
		{
			e1.setAdresse(ecole.getAdresse());
		}
		if(e1.getCp() != ecole.getCp() && ecole.getCp() != 0)
		{
			e1.setCp(ecole.getCp());
		}
		if(!e1.getVille().equals(ecole.getVille()) && ecole.getVille() != null)
		{
			e1.setVille(ecole.getVille());
		}
		if(!e1.getNom().equals(ecole.getNom()) && ecole.getNom() != null)
		{
			e1.setNom(ecole.getNom());
		}
		
		
		er.save(e1);
		
		return "the school : " + e1 + "has been update";
		
	}
	
	@DeleteMapping("/deleteEcole")
	public String deleteEcole(@RequestParam("id") int id)
	{
		er.deleteById(id);
		
		return "school delete";
	}
	
	@GetMapping("/scoolByEmail/{email}")
	public Ecole getSchoolByEmail(@PathVariable String email)
	{
		return er.findSchoolByEmailStudent(email);
	}
	
	
	

}
