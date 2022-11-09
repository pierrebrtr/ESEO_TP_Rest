package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	
	public ArrayList<Ville> findAllVilles() {
		System.out.println("find all villes");
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		
		
		
		Connection con = null;

	    String url = "jdbc:mysql://localhost:3306/villes";
	    String username = "root";
	    String password = "password";

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver");
		
	      con = DriverManager.getConnection(url, username, password);

	      String sql = " SELECT * FROM ville_france";


	      PreparedStatement stmt = con.prepareStatement(sql);

	      ResultSet rs = stmt.executeQuery();
	      while (rs.next()) {

	    	    Ville ville = new Ville();
	    		ville.setCodePostal(rs.getString("Code_postal"));
	    		ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
	    		ville.setLigne(rs.getString("Ligne_5"));
	    		ville.setNomCommune(rs.getString("Nom_commune"));
	    		ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
	    		
	    		listVille.add(ville);
	    	    
	    	}


	    } catch (SQLException | ClassNotFoundException ex) {
	        throw new Error("Error ", ex);
	    } finally {
	      try {
	        if (con != null) {
	            con.close();
	        }
	      } catch (SQLException ex) {
	          System.out.println(ex.getMessage());
	      }
	    }
		
		return listVille;
	}

}
