/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import persistencia.propietarioDAO;

/**
 *
 * @author ecarr
 */
public class indexAction extends ActionSupport {
    
    public indexAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String registrarForm() {
        return SUCCESS;
    }
    
    //public String comprobarLogin(){
    //    propietarioDAO dao = new propietarioDAO();    
    //}
    
}
