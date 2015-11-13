package com.action;

import java.io.IOException;
import java.util.List;

import com.dao.CrudDaoEmpleado;
import com.model.Empleado;
import com.opensymphony.xwork2.Action;
import java.sql.Date;

public class JtableActionEmpleado {
	
	private CrudDaoEmpleado dao = new CrudDaoEmpleado();

	private List<Empleado> records;
	private String result;
	private String message;
	private Empleado record;

     private String rut;
     private String nombres;
     private String apellidos;
     private String direccion;
     private Date fechaNac;
     private String cargasFam;
     private String telefono;
     private String email;
     private String password;     
     // claves foraneas  
     private int afp;
     private int ciudad;
     private int estadoCivil;
     private int nacionalidad;
     private int prevision;
     private int profesion;
     private int rol;

	public String list() {
		try {
			// Fetch Data from Empleado Table
			records = dao.getAllEmpleados();
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String create() throws IOException {
		record = new Empleado();
                
		record.setRut(this.rut);
		record.setNombres(this.nombres);
                record.setApellidos(this.apellidos);
                record.setDireccion(this.direccion);
                record.setFechaNac(this.fechaNac);
                record.setCargasFam(this.cargasFam);
                record.setTelefono(this.telefono);
                record.setEmail(this.email);
                record.setPassword(this.password);
                record.setAfp(this.afp);
                record.setCiudad(this.ciudad);
                record.setEstadoCivil(this.estadoCivil);
                record.setNacionalidad(this.nacionalidad);
                record.setPrevision(this.prevision);
                record.setProfesion(this.profesion);
                record.setRol(this.rol);
             
	
		try {
			// Create new record
			dao.addEmpleado(record);
			result = "OK";

		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;	
	}

	public String update() throws IOException {
		Empleado empleado = new Empleado();
		record.setRut(this.rut);
		record.setNombres(this.nombres);
                record.setApellidos(this.apellidos);
                record.setDireccion(this.direccion);
                record.setFechaNac(this.fechaNac);
                record.setCargasFam(this.cargasFam);
                record.setTelefono(this.telefono);
                record.setEmail(this.email);
                record.setPassword(this.password);
                record.setAfp(this.afp);
                record.setCiudad(this.ciudad);
                record.setEstadoCivil(this.estadoCivil);
                record.setNacionalidad(this.nacionalidad);
                record.setPrevision(this.prevision);
                record.setProfesion(this.profesion);
                record.setRol(this.rol);
		
		try {
			// Update existing record
			dao.updateEmpleado(empleado);
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
			dao.deleteEmpleado(this.rut);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

}