package com.inti.TD1Rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inti.TD1Rest.Controller.ProfesseurController;
import com.inti.TD1Rest.Repository.EcoleRepository;
import com.inti.TD1Rest.Repository.EtudiantRepository;
import com.inti.TD1Rest.Repository.ProfesseurRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProfesseurController.class)
public class ProfesseurControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EtudiantRepository er;
	
	@MockBean
	private EcoleRepository ecoleR;
	
	@MockBean
	private ProfesseurRepository pr;
	
	@Test
	public void testgetProfBySchoolOrderBySalaire()
	{
		try
		{
			mockMvc.perform(get("/getProfBySchoolOrderBySalaire/{id}", "1"))
				.andExpect(status().isOk());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
