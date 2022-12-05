package com.controller;


import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Ville;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.blo.VilleBLO;
import com.dto.Ville;

@Controller
public class WebsiteController {
	
	@Autowired
	VilleBLO villeBLOService;


	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model, HttpSession session) {
		ArrayList<Ville> listeVille;
		
		listeVille = villeBLOService.getInfosVilles();	
		
		
		model.addAttribute("villes", listeVille);
		return "greeting";
	}

}
