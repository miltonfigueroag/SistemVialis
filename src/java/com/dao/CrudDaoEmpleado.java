package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DataAccessObject;
import com.model.Empleado;
import com.model.Rol;
import com.model.Usuario;
import java.sql.CallableStatement;



public class CrudDaoEmpleado {

    private Connection dbConnection;
    private PreparedStatement pStmt;

    public CrudDaoEmpleado() {
        dbConnection = DataAccessObject.getConnection();
    }

    public void addEmpleado(Empleado empleado) {
        String insertQuery =    "INSERT INTO EMPLEADO (RUT,"
                                                     + "NOMBRES,"
                                                     + "APELLIDOS,"
                                                     + "DIRECCION,"
                                                     + "CIUDAD_ID,"
                                                     + "NACIONALIDAD_ID,"
                                                     + "FECHA_NAC,"
                                                     + "ESTADO_CIVIL_ID,"
                                                     + "CARGAS_FAM,"
                                                     + "AFP_ID,"
                                                     + "PREVISION_ID,"
                                                     + "TELEFONO,"
                                                     + "EMAIL,"
                                                     + "PROFESION_ID,"
                                                     + "ROL_ID,"
                                                     + "PASSWORD"                                                 
                                                     + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pStmt = dbConnection.prepareStatement(insertQuery);
            pStmt.setString(1, empleado.getRut());
            pStmt.setString(2, empleado.getNombres());
            pStmt.setString(3, empleado.getApellidos());
            pStmt.setString(4, empleado.getDireccion());
            pStmt.setInt(5, empleado.getCiudad());
            pStmt.setInt(6, empleado.getNacionalidad());
            pStmt.setDate(7,empleado.getFechaNac());        
            pStmt.setInt(8,empleado.getEstadoCivil());    
            pStmt.setString(9, empleado.getCargasFam());            
            pStmt.setInt(10, empleado.getAfp());
            pStmt.setInt(11, empleado.getPrevision());
            pStmt.setString(12, empleado.getTelefono());
            pStmt.setString(13, empleado.getEmail());
            pStmt.setInt(14, empleado.getProfesion());
            pStmt.setInt(15, empleado.getRol());
            pStmt.setString(16, empleado.getPassword());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void deleteEmpleado(String rut) {
        String deleteQuery = "DELETE FROM EMPLEADO WHERE RUT = ?";
        try {
            pStmt = dbConnection.prepareStatement(deleteQuery);
            pStmt.setString(1, rut);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateEmpleado(Empleado empleado) {
        String updateQuery = "UPDATE EMPLEADO SET RUT = ?,"
                                                 + "NOMBRES = ?,"
                                                 + "APELLIDOS = ?,"
                                                 + "DIRECCION = ?,"
                                                 + "CIUDAD_ID = ?,"
                                                 + "NACIONALIDAD_ID = ?,"
                                                 + "FECHA_NAC = ?,"
                                                 + "ESTADO_CIVIL_ID = ?,"
                                                 + "CARGAS_FAM = ?,"
                                                 + "AFP_ID = ?,"
                                                 + "PREVISION_ID = ?,"
                                                 + "TELEFONO = ?,"
                                                 + "EMAIL = ?,"
                                                 + "PROFESION_ID = ?,"
                                                 + "ROL_ID = ?,"
                                                 + "PASSWORD = ?"                                                
                                                 +"  WHERE RUT = ?";
        try {
            pStmt = dbConnection.prepareStatement(updateQuery);
            
            pStmt.setString(1, empleado.getRut());
            pStmt.setString(2, empleado.getNombres());
            pStmt.setString(3, empleado.getApellidos());
            pStmt.setString(4, empleado.getDireccion());
            pStmt.setInt(5, empleado.getCiudad());
            pStmt.setInt(6, empleado.getNacionalidad());
            pStmt.setDate(7,empleado.getFechaNac());        
            pStmt.setInt(8,empleado.getEstadoCivil());    
            pStmt.setString(9, empleado.getCargasFam());            
            pStmt.setInt(10, empleado.getAfp());
            pStmt.setInt(11, empleado.getPrevision());
            pStmt.setString(12, empleado.getTelefono());
            pStmt.setString(13, empleado.getEmail());
            pStmt.setInt(14, empleado.getProfesion());
            pStmt.setInt(15, empleado.getRol());
            pStmt.setString(16, empleado.getPassword());
            pStmt.setString(17, empleado.getRut());
            
            pStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

   public List<Empleado> getAllEmpleados() {
        List<Empleado> empleados = new ArrayList<Empleado>();
        String query = "SELECT * FROM EMPLEADO ORDER BY RUT";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Empleado empleado = new Empleado();                 
                empleado.setRut(rs.getString(1));
                empleado.setNombres(rs.getString(2));
                empleado.setApellidos(rs.getString(3));
                empleado.setDireccion(rs.getString(4));                
                empleado.setCiudad(rs.getInt(5));
                empleado.setNacionalidad(rs.getInt(6));                
                empleado.setFechaNac(rs.getDate(7));                
                empleado.setEstadoCivil(rs.getInt(8));
                empleado.setCargasFam(rs.getString(9));
                empleado.setAfp(rs.getInt(10));
                empleado.setPrevision(rs.getInt(11));
                empleado.setTelefono(rs.getString(12));
                empleado.setEmail(rs.getString(13));
                empleado.setProfesion(rs.getInt(14));
                empleado.setRol(rs.getInt(15));
                empleado.setPassword(rs.getString(16));
                
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return empleados;
    }
   
      
       
       public Usuario ValidarUsuario(String User, String Clave) throws Exception {

        CallableStatement Cstm = null;
        ResultSet Rst = null;
        Usuario usuario = new Usuario();
        Rol r = new Rol();
        try{         
            String Comando = "call pa_ValidarUsuario(?,?)";
            Cstm = dbConnection.prepareCall(Comando);
            Cstm.setString(1, User);
            Cstm.setString(2, Clave);
            Rst = Cstm.executeQuery();
            while(Rst.next()){
                usuario.setNombres(Rst.getString(1));             
                        Rol rol= new Rol();               
                        rol.setId(1);
                        rol.setNombres("master");
                        rol.setPrivilegios("todos");
                usuario.setRol(rol);
                usuario.setEmail(Rst.getString(2));
                usuario.setPassword(Rst.getString(3));                    
            }
            System.out.println("exito login en ----> ValidarEmpleado ");
        }catch(Exception e){
            System.out.println("error login en ----> ValidarEmpleado");
        }
        return usuario;
    }
}
