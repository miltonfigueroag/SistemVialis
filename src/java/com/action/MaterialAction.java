package com.action;

import java.io.IOException;
import java.util.List;


import com.dao.CrudDaoMaterial;
import com.model.Material;
import com.opensymphony.xwork2.Action;

public class MaterialAction {
	
	private CrudDaoMaterial dao = new CrudDaoMaterial();

	private List<Material> records;
	private String result;
	private String message;
	private Material record;

	private int codigo;	
	private String articul;
	private String u_medida;
	private String marca;

	public String list() {
		try {
			// Fetch Data from Material Table
			records = dao.getAllMateriales();
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String create() throws IOException {
		record = new Material();
		
		record.setCodigo(codigo);
		record.setArticulo(articul);
                record.setU_medida(u_medida);
		record.setMarca(marca);
		
	
		try {
			// Create new record
			dao.addMateriales(record);
			result = "OK";

		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;	
	}

	public String update() throws IOException {
		Material material = new Material();
		
		material.setCodigo(codigo);
		material.setArticulo(articul);
		material.setU_medida(u_medida);
		material.setMarca(marca);
		
		try {
			// Update existing record
			dao.updateMateriales(material);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String delete() throws IOException {
		// Delete record
		try {
			dao.deleteMateriales(this.codigo);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

    public CrudDaoMaterial getDao() {
        return dao;
    }

    public void setDao(CrudDaoMaterial dao) {
        this.dao = dao;
    }

    public List<Material> getRecords() {
        return records;
    }

    public void setRecords(List<Material> records) {
        this.records = records;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Material getRecord() {
        return record;
    }

    public void setRecord(Material record) {
        this.record = record;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getArticulo() {
        return articul;
    }

    public void setArticulo(String articulo) {
        this.articul = articulo;
    }

    public String getU_medida() {
        return u_medida;
    }

    public void setU_medida(String u_medida) {
        this.u_medida = u_medida;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
        
}
