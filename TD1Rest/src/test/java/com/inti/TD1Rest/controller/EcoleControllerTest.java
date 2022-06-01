package com.inti.TD1Rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inti.TD1Rest.Repository.EcoleRepository;
import com.inti.TD1Rest.Repository.EtudiantRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EtudiantController.class)
public class EcoleControllerTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EtudiantRepository er;
	
	@MockBean
	private EcoleRepository ecoleR;
	
	@Test
	public void testGetShcoolByNomAndPrenom()
	{
		try
		{
			mockMvc.perform(get("/scoolByNomAndPrenom/{nom}/{prenom}","Alice","Alice"))
				.andExpect(status().isOk());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	

}
