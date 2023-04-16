package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
@RequestMapping(value="/villes")
public class VilleController {
	
	@Autowired
	VilleBLO villeBLOService;
	
	/*@RequestMapping(value="/ville/{codePostal}",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> get(@RequestParam(required = false, value="codePostal") String codePostal) {
		System.out.println("get : " + codePostal);
	
		ArrayList<Ville> listeVille = villeBLOService.getInfoVilles(codePostal);
		
		return listeVille;
	}*/
	
	@GetMapping("/{codePostal}")
	public Ville getVille(@PathVariable String codePostal) {
		System.out.println("get : " + codePostal);
	
		Ville ville = villeBLOService.getInfoVille(codePostal);
		
		return ville;
	}
	
	@GetMapping("")
	public ArrayList<Ville> getAllVilles() {
		ArrayList<Ville> listeVille = villeBLOService.findAllVilles();
		return listeVille;
	}
	
	@DeleteMapping("/{codePostal}")
	public void deleteVille(@PathVariable String codePostal) {
		System.out.println("delete : " + codePostal);
		villeBLOService.deleteVille(codePostal);
	}
	
	@PutMapping("/{codeInsee}/{nomCommune}/{codePostal}/{libelleAcheminement}/{ligne}")
	public void insertVille(@PathVariable String codeInsee, @PathVariable String nomCommune,
			@PathVariable String codePostal, @PathVariable String libelleAcheminement,
			@PathVariable String ligne ) {
		System.out.println("insert : " + codePostal);
		villeBLOService.insertVille(codeInsee, nomCommune, codePostal, libelleAcheminement, ligne);
	}
}