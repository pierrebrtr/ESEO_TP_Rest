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
	Connection con = null;

    String url = "jdbc:mysql://localhost:3306/villes";
    String username = "root";
    String password = "password";
	public ArrayList<Ville> findAllVilles() {
		System.out.println("find all villes");
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		

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
	    		ville.setLatitude(rs.getString("Latitude"));
	    		ville.setLongitude(rs.getString("Longitude"));
	    		
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
	
	public ArrayList<Ville> findVille(String nomCommune) {
		System.out.println("find specific city : " + nomCommune);
		
		ArrayList<Ville> listVille = new ArrayList<Ville>();
		

	    try {

	        Class.forName("com.mysql.cj.jdbc.Driver");
		
	      con = DriverManager.getConnection(url, username, password);
	     

	      String sql = " SELECT * FROM ville_france WHERE Nom_commune='" + nomCommune + "'";


	      PreparedStatement stmt = con.prepareStatement(sql);

	      ResultSet rs = stmt.executeQuery();
	      while (rs.next()) {

	    	    Ville ville = new Ville();
	    		ville.setCodePostal(rs.getString("Code_postal"));
	    		ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
	    		ville.setLigne(rs.getString("Ligne_5"));
	    		ville.setNomCommune(rs.getString("Nom_commune"));
	    		ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
	    		ville.setLatitude(rs.getString("Latitude"));
	    		ville.setLongitude(rs.getString("Longitude"));
	    		
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
	
	public Boolean deleteCity(String nomCommune) {
	
		 	try {

		      Class.forName("com.mysql.cj.jdbc.Driver");
			
		      con = DriverManager.getConnection(url, username, password);
		     

		      String sql = "DELETE FROM ville_france WHERE Nom_commune='" + nomCommune + "'";


		      PreparedStatement stmt = con.prepareStatement(sql);

		      int rs = stmt.executeUpdate();
		      System.out.println(rs);
		      if (rs == 0) {
		    	  return false;
		      }


		    } catch (SQLException | ClassNotFoundException ex) {
		    	 System.out.println(ex);
		        return false;
		       
		    } finally {
		      try {
		        if (con != null) {
		            con.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    }
		return true;
	}
	
	public Boolean addCity(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne) {
		try {

		      Class.forName("com.mysql.cj.jdbc.Driver");
			
		      con = DriverManager.getConnection(url, username, password);
		     

		      String sql = "INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) VALUES ('" + codeCommune + "', '" + nomCommune + "', '" + codePostal + "', '" + libelleAcheminement + "', '" + ligne + "', '0', '0')";


		      PreparedStatement stmt = con.prepareStatement(sql);

		      int rs = stmt.executeUpdate();
		      System.out.println(rs);
		      if (rs == 0) {
		    	  return false;
		      }


		    } catch (SQLException | ClassNotFoundException ex) {
		    	 System.out.println(ex);
		        return false;
		       
		    } finally {
		      try {
		        if (con != null) {
		            con.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    }
		return true;
	}
	
	public Boolean modifyCity(String codeCommune, String nomCommune, String codePostal, String libelleAcheminement, String ligne) {
		try {

		      Class.forName("com.mysql.cj.jdbc.Driver");
			
		      con = DriverManager.getConnection(url, username, password);
		     
		      

		      String sql = "UPDATE ville_france SET Code_commune_INSEE='"+ codeCommune +"', Code_postal='"+ codePostal +"', Libelle_acheminement='"+ libelleAcheminement +"', Ligne_5='" + ligne + "' WHERE Nom_commune='" + nomCommune + "'";


		      PreparedStatement stmt = con.prepareStatement(sql);

		      int rs = stmt.executeUpdate();
		      System.out.println(rs);
		      if (rs == 0) {
		    	  return false;
		      }


		    } catch (SQLException | ClassNotFoundException ex) {
		    	 System.out.println(ex);
		        return false;
		       
		    } finally {
		      try {
		        if (con != null) {
		            con.close();
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    }
		return true;
	}
	

}
