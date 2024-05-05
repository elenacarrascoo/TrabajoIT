/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
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
    private String password;
    private String rolUsuario;
    
    public indexAction() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
    
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        
        Propietario p = new Propietario();
        propietarioDAO daoProp = new propietarioDAO();
        p = daoProp.loginPropietario(this.getDni(), this.getPassword());
                
        if(p!=null){
            session.put("propietario", p);
            return "propietario";
        }else{
            veterinarioDAO daoVet= new veterinarioDAO();
            Veterinario v = daoVet.loginVeterinario(this.getDni(), this.getPassword());
            if(v!=null){
                session.put("veterinario", v);
                return "veterinario";
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
    
    public void validate() {
        String actionName = ActionContext.getContext().getName();

        if (actionName.equals("login")) {

            if (this.getDni().equals("")) {
                addFieldError("dni", "Introduce el dni");
            } 

            if (this.getPassword().equals("")) {
                addFieldError("password", "Introduce la contraseña");
            }
        }
    }
        
}
