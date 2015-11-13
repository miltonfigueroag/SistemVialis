package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DataAccessObject;
import com.model.Material;

public class CrudDaoMaterial {

private Connection dbConnection;
private PreparedStatement pStmt;

public CrudDaoMaterial() {
	dbConnection = DataAccessObject.getConnection();
}

public void addMateriales(Material material) {
	String insertQuery = "INSERT INTO MATERIALES(CODIGO, ARTICULO, " +
			"U_MEDIDA, MARCA) VALUES (INCREMENTO_MATERIALES_SEQ.NextVal,?,?,?)";
	try {
		pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, material.getArticulo());
		pStmt.setString(2, material.getU_medida());
		pStmt.setString(3, material.getMarca());
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public void deleteMateriales(int codigo) {
	String deleteQuery = "DELETE FROM MATERIALES WHERE CODIGO = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1, codigo);
		pStmt.executeUpdate();
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public void updateMateriales(Material material)  {
	String updateQuery = "UPDATE MATERIALES SET ARTICULO = ?, " +
			"U_MEDIDA = ?, MARCA = ? WHERE CODIGO = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, material.getArticulo());
		pStmt.setString(2, material.getU_medida());
		pStmt.setString(3, material.getMarca());
		pStmt.setInt(4, material.getCodigo());
		pStmt.executeUpdate();

	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
}

public List<Material> getAllMateriales() {
	List<Material> materials = new ArrayList<Material>();

	String query = "SELECT * FROM MATERIALES ORDER BY CODIGO";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Material material = new Material();

			material.setCodigo(rs.getInt("CODIGO"));
			material.setArticulo(rs.getString("ARTICULO"));
			material.setU_medida(rs.getString("U_MEDIDA"));
			material.setMarca(rs.getString("MARCA"));
			materials.add(material);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return materials;
}
}
