/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Paciente;
import modelo.Propietario;
import persistencia.pacienteDAO;
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
    private String password;
    private List<Paciente> listaPacientes;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public String execute() throws Exception {
        propietarioDAO pdao = new propietarioDAO();
        Propietario p = new Propietario(this.getDni(), this.getNombre(), this.getDireccion(), this.getTelefono(), this.getCorreo(), this.getInfoContactoAdicional(), this.getPassword());
        pdao.altaPropietario(p);
        return SUCCESS;
    }

    public String listarPacientesPropietario() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        pacienteDAO pDAO = new pacienteDAO();
        Propietario p = (Propietario) session.get("propietario");
        List<Paciente> listaPacientes = pDAO.obtenerPacientes(p);
        this.setListaPacientes(listaPacientes);
        return SUCCESS;
    }

    public String actualizarPropietario() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        Propietario p = (Propietario) session.get("propietario");
        p.setNombre(this.getNombre());
        p.setDireccion(this.getDireccion());
        p.setTelefono(this.getTelefono());
        p.setCorreo(this.getCorreo());
        p.setInfoContactoAdicional(this.getInfoContactoAdicional());
        return SUCCESS;
    }
    
    public String logout() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }
    
    public void validate() {
        String actionName = ActionContext.getContext().getName();

        if (actionName.equals("registrarPropietario")) {
            String patronDNI = "[0-9]{7,8}[A-Z a-z]";
            Pattern patron1 = Pattern.compile(patronDNI);
            Matcher macheadorDNI = patron1.matcher(this.getDni());

            if (this.getDni().equals("")) {
                addFieldError("dni", "Introduce el dni");
            } else if (!macheadorDNI.matches()) {
                addFieldError("dni", "Formato de dni incorrecto");
            }

            if (this.getPassword().equals("")) {
                addFieldError("password", "Introduce la contraseña");
            } else if (this.getPassword().length() < 8 || this.getPassword().length() > 11) {
                addFieldError("password", "La contraseña debe tener entre 8 y 11 caracteres");
            }

            if (this.getNombre().equals("")) {
                addFieldError("nombre", "Introduce el nombre");
            }

            if (this.getTelefono() == 0) {
                addFieldError("telefono", "Introduce el teléfono");
            }

        }
        
        if(actionName.equals("registrarActualizacion")){
            if (this.getNombre().equals("")) {
                addFieldError("nombre", "Introduce el nombre");
            }

            if (this.getTelefono() == 0) {
                addFieldError("telefono", "Introduce el teléfono");
            }
        }
    }
   
}
