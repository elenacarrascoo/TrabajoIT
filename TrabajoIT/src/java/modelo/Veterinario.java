package modelo;
// Generated 21-may-2024 20:42:03 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Veterinario generated by hbm2java
 */
public class Veterinario  implements java.io.Serializable {


     private String dni;
     private String nombre;
     private String especialidad;
     private int experiencia;
     private int telefono;
     private String correo;
     private String password;
     private Set citas = new HashSet(0);

    public Veterinario() {
    }

	
    public Veterinario(String dni, String nombre, String especialidad, int experiencia, int telefono, String correo, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
    }
    public Veterinario(String dni, String nombre, String especialidad, int experiencia, int telefono, String correo, String password, Set citas) {
       this.dni = dni;
       this.nombre = nombre;
       this.especialidad = especialidad;
       this.experiencia = experiencia;
       this.telefono = telefono;
       this.correo = correo;
       this.password = password;
       this.citas = citas;
    }
   
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEspecialidad() {
        return this.especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    public int getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set citas) {
        this.citas = citas;
    }




}


