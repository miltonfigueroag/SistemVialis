/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.jdbc.DataAccessObject;
import com.model.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CrudDaoCiudad {
    private Connection dbConnection;
    private PreparedStatement pStmt;

    public CrudDaoCiudad() {
        dbConnection = DataAccessObject.getConnection();
    }

    public void addCiudad(Ciudad material) {
	String insertQuery = "INSERT INTO CIUDAD(ID,NOMBRE) VALUES (?,?)";
	try {
		pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setInt(1, material.getId());
		pStmt.setString(2, material.getNombre());
				pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public void deleteCiudad(int id) {
	String deleteQuery = "DELETE FROM CIUDAD WHERE ID = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1,id);
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public void updateCiudad(Ciudad material)  {
	String updateQuery = "UPDATE CIUDAD SET NOMBRE = ? WHERE ID  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, material.getNombre());
		pStmt.setInt(2, material.getId());
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}


    public List<Ciudad> getAllCiudades() {
	List<Ciudad> ciudades = new ArrayList<Ciudad>();
        
	String query = "SELECT * FROM CIUDAD";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Ciudad ciudad = new Ciudad();
			ciudad.setId(rs.getInt("ID"));
			ciudad.setNombre(rs.getString("NOMBRE"));			
			ciudades.add(ciudad);		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return ciudades;
}

 
      
}
