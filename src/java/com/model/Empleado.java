package com.model;
import java.sql.Date;

public class Empleado {
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

    public Empleado() {
    }

    public Empleado(String rut, String nombres, String apellidos, String direccion, Date fechaNac, String cargasFam, String telefono, String email, String password, int afp, int ciudad, int estadoCivil, int nacionalidad, int prevision, int profesion, int rol) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNac = fechaNac;
        this.cargasFam = cargasFam;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.afp = afp;
        this.ciudad = ciudad;
        this.estadoCivil = estadoCivil;
        this.nacionalidad = nacionalidad;
        this.prevision = prevision;
        this.profesion = profesion;
        this.rol = rol;
    }
    
    

    public String getRut() {
        
       
        return rut;   
    }

    public void setRut(String rut) {
         try {
          this.rut = rut;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
              try {
     this.nombres = nombres;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
              try {
             this.apellidos = apellidos;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
   
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
              try {
      this.direccion = direccion;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
              try {
           this.fechaNac = fechaNac;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    
    }

 

    public String getCargasFam() {
        return cargasFam;
    }

    public void setCargasFam(String cargasFam) {
              try {
               this.cargasFam = cargasFam;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
   
    }

  

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
              try {
           this.telefono = telefono;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
              try {
          this.email = email;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
              try {
              this.password = password;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
   
    }

    public int getAfp() {
        return afp;
    }

    public void setAfp(int afp) {
              try {
         this.afp = afp;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
     
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
              try {
                  this.ciudad = ciudad;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
              try {
         this.estadoCivil = estadoCivil;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
       
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(int nacionalidad) {
              try {
        this.nacionalidad = nacionalidad;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }

    public int getPrevision() {
        return prevision;
    }

    public void setPrevision(int prevision) {
        try {
            this.prevision = prevision;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public int getProfesion() {
        return profesion;
    }

    public void setProfesion(int profesion) {
              try {
            this.profesion = profesion;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
              try {
     this.rol = rol;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
     
    }    
}
