package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO{
	
	@Autowired
	private VilleDAO villeDAO;
	
	public ArrayList<Ville> getInfosVilles(String nomCommune) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		listVille = villeDAO.findVille(nomCommune);
		return listVille;
	}
	
	public ArrayList<Ville> getInfosVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		listVille = villeDAO.findAllVilles();
		return listVille;
	}
	
	public Boolean deleteVille(String nomCommune) {

		return villeDAO.deleteCity(nomCommune);
	}
	
	public Boolean addVille(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne) {
		
		return villeDAO.addCity(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne);
	}

public Boolean modifierVille(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne) {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		listVille = villeDAO.findVille(nomCommune);
		if(listVille.size() > 0) {
			Ville mainVille = listVille.get(0);
			
			if(codeCommune == "") {
				codeCommune = mainVille.getCodeCommune();
			}
			if(codePostal == "") {
				codePostal = mainVille.getCodePostal();
			}
			if(libelleAcheminement == "") {
				libelleAcheminement = mainVille.getLibelleAcheminement();
			}
			if(ligne == "") {
				ligne = mainVille.getLigne();
			}
			return villeDAO.modifyCity(codeCommune, nomCommune, codePostal, libelleAcheminement, ligne);
		} else {
			return false;
		}
		
	}
}
