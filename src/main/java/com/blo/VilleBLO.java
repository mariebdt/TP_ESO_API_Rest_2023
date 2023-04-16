package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	public Ville getInfoVille(String codePostal);
	
	public ArrayList<Ville> findAllVilles();
	
	public void deleteVille(String codePostal);
	
	public void insertVille(String codeInsee, String nomCommune, String codePostal, String libelleAcheminement, String ligne);
}
