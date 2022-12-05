package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	public ArrayList<Ville> getInfosVilles(String nomCommune);
	public ArrayList<Ville> getInfosVilles();
	
	public Boolean addVille(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne);
	public Boolean modifierVille(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne);
	
	public Boolean deleteVille(String nomCommune);

}
