package com.inti.TD1Rest.Controller;

import com.inti.TD1Rest.Repository.EcoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoleController 
{
	@Autowired
	EcoleRepository er;
	
	

}
