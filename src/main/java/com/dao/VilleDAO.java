package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	public ArrayList<Ville> findAllVilles();
	public Ville getInfoVille(String codePostal);
	public void deleteVille(String codePostal);
	public void insertVille(String codeInsee, String nomCommune, String codePostal, String libelleAcheminement, String ligne);
}