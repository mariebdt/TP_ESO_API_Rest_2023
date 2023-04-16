package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{
	public ArrayList<Ville> findAllVilles() {
		
		System.out.println("findAllVilles");
		
		ArrayList<Ville> listeVille = new ArrayList<Ville>();
		
		
		try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection conn = DriverManager.getConnection(
	      "jdbc:mysql://localhost:8889/TP_ESEO_MAVEN", "root", "root");
	      Statement stmt = conn.createStatement();
	      ResultSet res = stmt.executeQuery("SELECT * FROM ville_france");
	      while(res.next()) {
	        Ville ville = new Ville();
	        ville.setCodeCommune(res.getString("Code_commune_INSEE"));
	        ville.setNomCommune(res.getString("Nom_commune"));
	        ville.setCodePostal(res.getString("Code_postal"));
	        ville.setLibelleAcheminement(res.getString("Libelle_acheminement"));
	        ville.setLigne(res.getString("Ligne_5"));
	        listeVille.add(ville);
	      }
	      conn.close();
	    }
	    catch(Exception e){ 
	      System.out.println(e);
	    }
		
		return listeVille;
	}
	
	public Ville getInfoVille(String codePostal) {
		System.out.println("getInfoVille");
		Ville ville = new Ville();
		try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection conn = DriverManager.getConnection(
	      "jdbc:mysql://localhost:8889/TP_ESEO_MAVEN", "root", "root");
	      Statement stmt = conn.createStatement();
	      ResultSet res = stmt.executeQuery("SELECT * FROM ville_france");
	      while(res.next()) {
				Ville villeTemp = new Ville();
				villeTemp.setCodeCommune(res.getString("Code_commune_INSEE"));
				villeTemp.setNomCommune(res.getString("Nom_commune"));
				villeTemp.setCodePostal(res.getString("Code_postal"));
				villeTemp.setLibelleAcheminement(res.getString("Libelle_acheminement"));
				villeTemp.setLigne(res.getString("Ligne_5"));
				if((villeTemp.getCodePostal()).equals(codePostal)) {
					ville = villeTemp;
					break;
				}
	      }
	      conn.close();
	    }
	    catch(Exception e){ 
	      System.out.println(e);
	    }
		return ville;
	}
	
	public void deleteVille(String codePostal) {
		System.out.println("deleteVille");
		try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection conn = DriverManager.getConnection(
	      "jdbc:mysql://localhost:8889/TP_ESEO_MAVEN", "root", "root");
	      Statement stmt = conn.createStatement();
	      stmt.executeUpdate("DELETE FROM ville_france WHERE Code_postal = '\"+codePostal+\"'");
	      conn.close();
	    }
	    catch(Exception e){ 
	      System.out.println(e);
	    }
	}
	
	public void insertVille(String codeInsee, String nomCommune, String codePostal, String libelleAcheminement, String ligne) {
		System.out.println("insertVille");
		try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      Connection conn = DriverManager.getConnection(
	      "jdbc:mysql://localhost:8889/TP_ESEO_MAVEN", "root", "root");
	      Statement stmt = conn.createStatement();
	      stmt.executeUpdate("INSERT INTO `ville_france` (`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`)"
	      		+ "VALUES ('\"+codeInsee+\"', '\"+nomCommune+\"', '\"+codePostal+\"',"
	      		+ "'\"+libelleAcheminement+\"', '\"+ligne+\"', \"\", \"\")");
	      conn.close();
	    }
	    catch(Exception e){ 
	      System.out.println(e);
	    }
	}
}
