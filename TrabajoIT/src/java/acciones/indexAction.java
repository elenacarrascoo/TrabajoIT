/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import modelo.Propietario;
import modelo.Veterinario;
import persistencia.propietarioDAO;
import persistencia.veterinarioDAO;

/**
 *
 * @author ecarr
 */
public class indexAction extends ActionSupport {
    
    private String dni;
    private String nombre;
    private String rolUsuario;
    
    public indexAction() {
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
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String registrarForm() {
        return SUCCESS;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    
    public String comprobarLogin(){
        propietarioDAO daoProp = new propietarioDAO();
        Propietario p = daoProp.loginPropietario(this.getNombre(), this.getDni());
        
        if(p!=null){
            return "propietario";
        }else{
            veterinarioDAO daoVet= new veterinarioDAO();
            Veterinario v = daoVet.loginVeterinario(this.getNombre(), this.getDni());
            if(v!=null){
                return "veterinaro";
            }else{
                return ERROR;
            }
        }
    }
    
    public String elegirRegistro(){
        if(this.getRolUsuario().equals("propietario")){
            return "altaPropietario";
        }else if(this.getRolUsuario().equals("veterinario")){
            return "altaVeterinario";
        }else{
            return ERROR;
        }
    }
    
}
