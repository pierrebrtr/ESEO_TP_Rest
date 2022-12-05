package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {
	
	@Autowired
	VilleBLO villeBLOService;

	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> get(@RequestParam(required = false, value="nomCommune") String nomCommune) {
		System.out.println("get");
		ArrayList<Ville> listeVille;
		if (nomCommune != null) {
			 listeVille = villeBLOService.getInfosVilles(nomCommune);	
		} else {
			listeVille = villeBLOService.getInfosVilles();	
		}
		return listeVille;
	}
	
	
	@RequestMapping(value = "/ville", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Long> delete(@RequestParam(required = true, value="nomCommune") String nomCommune) {
		System.out.println("delete with " + nomCommune);
		
		Boolean isRemoved = villeBLOService.deleteVille(nomCommune);
		if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//TODO
	@RequestMapping(value = "/ville", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Long> post(@RequestBody Ville ville) {
		System.out.println("post");
				
		Boolean isRemoved = villeBLOService.addVille(ville.getCodeCommune(), ville.getNomCommune(), ville.getCodePostal(), ville.getLibelleAcheminement(),ville.getLigne());
		if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ville", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Long> put(@RequestParam(required = false, value="nomCommune") String nomCommune, 
			@RequestParam(required = false, value="codeCommune") String codeCommune,
			@RequestParam(required = false, value="codePostal") String codePostal,
			@RequestParam(required = false, value="libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value="ligne") String ligne) {
		System.out.println("post");
		
		if(nomCommune == null) {
			nomCommune = "";
		}
		if(codeCommune == null) {
			codeCommune = "";
		}
		if(codePostal == null) {
			codePostal = "";
		}
		if(libelleAcheminement == null) {
			libelleAcheminement = "";
		}
		if(ligne == null) {
			ligne = "";
		}
		
		Boolean isRemoved = villeBLOService.modifierVille(codeCommune, nomCommune, codePostal, libelleAcheminement,ligne);
		if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
