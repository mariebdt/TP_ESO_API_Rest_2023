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
	
	public Ville getInfoVille(String codePostal) {
		Ville ville = null;
		
		ville = villeDAO.getInfoVille(codePostal);
		return ville;
	}
	
	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		listVille = villeDAO.findAllVilles();
		return listVille;
	}

	public void deleteVille(String codePostal) {
		villeDAO.deleteVille(codePostal);
	}
	
	public void insertVille(String codeInsee, String nomCommune, String codePostal, 
			String libelleAcheminement, String ligne) {
		villeDAO.insertVille(codeInsee, nomCommune, codePostal, libelleAcheminement, ligne);
	}

}
