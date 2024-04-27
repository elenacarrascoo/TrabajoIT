/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Propietario;
import persistencia.propietarioDAO;

/**
 *
 * @author ecarr
 */
public class propietarioAction extends ActionSupport {
    
    private String dni;
    private String nombre;
    private String direccion;
    private int telefono;
    private String correo;
    private String infoContactoAdicional;
    
    public propietarioAction() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getInfoContactoAdicional() {
        return infoContactoAdicional;
    }

    public void setInfoContactoAdicional(String infoContactoAdicional) {
        this.infoContactoAdicional = infoContactoAdicional;
    }
    
    public String execute() throws Exception {
        propietarioDAO pdao = new propietarioDAO();
        Propietario p = new Propietario(this.getDni(), this.getNombre(), this.getDireccion(), this.getTelefono(), this.getCorreo(), this.getInfoContactoAdicional());
        pdao.altaPropietario(p);
        return SUCCESS;
    }
    
}
