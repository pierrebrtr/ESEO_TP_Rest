package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> findAllVilles();
	public ArrayList<Ville> findVille(String nomCommune);
	
	public Boolean deleteCity(String nomCommune);
	public Boolean addCity(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne);
	public Boolean modifyCity(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne);
	

	

}
