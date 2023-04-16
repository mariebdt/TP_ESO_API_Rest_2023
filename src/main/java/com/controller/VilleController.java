package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
@RequestMapping(value="/ville")
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
	public ArrayList<Ville> getVille(@PathVariable String codePostal) {
		System.out.println("get : " + codePostal);
	
		ArrayList<Ville> listeVille = villeBLOService.getInfoVilles(codePostal);
		
		return listeVille;
	}
}