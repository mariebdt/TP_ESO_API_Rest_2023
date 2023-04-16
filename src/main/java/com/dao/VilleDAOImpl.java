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
		
		
		try
	    {
	      //étape 1: charger la classe de driver
	      Class.forName("com.mysql.jdbc.Driver");
	      //étape 2: créer l'objet de connexion
	      Connection conn = DriverManager.getConnection(
	      "jdbc:mysql://localhost:8889/TP_ESEO_MAVEN", "root", "root");
	      //étape 3: créer l'objet statement 
	      Statement stmt = conn.createStatement();
	      ResultSet res = stmt.executeQuery("SELECT nom_commune FROM ville_france");
	      //étape 4: exécuter la requête
	      while(res.next())
	        System.out.println(res.getString(1));
	      //étape 5: fermez l'objet de connexion
	      conn.close();
	    }
	    catch(Exception e){ 
	      System.out.println(e);
	    }
		
		
		
		ArrayList<Ville> listeVille = new ArrayList<Ville>();
		Ville ville = new Ville();
		ville.setCodePostal("44000");
		ville.setLigne("ligne");
		ville.setNomCommune("test");
		
		listeVille.add(ville);
		
		return listeVille;
	}
	
	public ArrayList<Ville> getInfoVille(String codePostal) {
		System.out.println("getInfoVille");
		try
	    {
	      //étape 1: charger la classe de driver
	      Class.forName("com.mysql.jdbc.Driver");
	      //étape 2: créer l'objet de connexion
	      Connection conn = DriverManager.getConnection(
	      "jdbc:mysql://localhost:8889/TP_ESEO_MAVEN", "root", "root");
	      //étape 3: créer l'objet statement 
	      Statement stmt = conn.createStatement();
	      ResultSet res = stmt.executeQuery("SELECT nom_commune FROM ville_france");
	      //étape 4: exécuter la requête
	      while(res.next())
	        System.out.println(res.getString(1));
	      //étape 5: fermez l'objet de connexion
	      conn.close();
	    }
	    catch(Exception e){ 
	      System.out.println(e);
	    }
		ArrayList<Ville> listeVille = new ArrayList<Ville>();
		return listeVille;
	}
}
