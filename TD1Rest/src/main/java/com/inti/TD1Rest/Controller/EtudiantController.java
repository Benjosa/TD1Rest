package com.inti.TD1Rest.Controller;

import java.util.List;

import com.inti.TD1Rest.Repository.EcoleRepository;
import com.inti.TD1Rest.Repository.EtudiantRepository;
import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

@RestController  //WEB SERVICE
public class EtudiantController 
{
	
	@Autowired
	EtudiantRepository er;
	
	@Autowired
	EcoleRepository ecoleR;
	
	
	@GetMapping("/test")
	public String hello()
	{
		
		return "Hello World!";
	}
	
	@PostMapping("/addEtudiant")
	public ResponseEntity<Etudiant> saveStudent(@RequestBody Etudiant etudiant)
	{
		
		return new ResponseEntity<Etudiant>(er.save(etudiant), HttpStatus.CREATED);
	}
	
	@GetMapping("/allEtudiants")
	public ResponseEntity<List<Etudiant>> getAllEtudiants()
	{
		
		return new ResponseEntity<List<Etudiant>>(er.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@RequestBody Etudiant etudiant, @PathVariable int id)
	{
		 Etudiant e1 = er.getReferenceById(id);
		 
		
		 if(!e1.getNom().equals(etudiant.getNom()))
		 {
			 e1.setNom(etudiant.getNom());
		 }
		 if(!e1.getPrenom().equals(etudiant.getPrenom())&& etudiant.getPrenom()!= null)
		 {
			 e1.setPrenom(etudiant.getPrenom());
		 }
		
		er.save(e1);
		
		return "The student :" + e1 + " has been update";
	}
	
	@PutMapping("/updateStudentWithSchool/{idEtudiant}/{idEcole}")
	public String updateStudentWithSchool(@RequestBody Etudiant etudiant, @PathVariable int idEtudiant, @PathVariable int idEcole)
	{
		 Ecole ecole = ecoleR.getReferenceById(idEcole);
		 
		 etudiant.setEcole(ecole);
		 
		 er.save(etudiant);
		
		return "The student :" + etudiant + " has been update";
	}
	
	
	
	@DeleteMapping("/deleteEtudiant")
	public String deleteStudent(@RequestParam("id") int id)
	{
		er.deleteById(id);
		
		return "Student delete";
	}
	
	@GetMapping("/getEtudiant")
	public Etudiant getEtudiant()
	{
		
		return er.getReferenceById(3);
	}
	
	
	@GetMapping("/allEtudiantByEcole/{idEcole}")
	public ResponseEntity<List<Etudiant>> allEtudiantByEcole(@PathVariable int idEcole)
	{
		return new ResponseEntity<List<Etudiant>>(er.findAllByIdEcole(idEcole), HttpStatus.OK);
	}
	
	@GetMapping("/studentsInLyon")
	public ResponseEntity<List<Etudiant>> getAllstudentsInLyon()
	{
		
		return new ResponseEntity<List<Etudiant>>(er.findAllByVille(), HttpStatus.OK);
	}
	
	@GetMapping("/getAllStudentsByTeacher")
	public ResponseEntity<List<Etudiant>> getAllStudentsByTeacher(@RequestParam("id") int id)
	{
		return new ResponseEntity<List<Etudiant>>(er.getAllStudentsByTeacher(id), HttpStatus.OK);
	}
		
	

}
