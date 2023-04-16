package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	public ArrayList<Ville> findAllVilles();
	public ArrayList<Ville> getInfoVille(String codePostal);
}