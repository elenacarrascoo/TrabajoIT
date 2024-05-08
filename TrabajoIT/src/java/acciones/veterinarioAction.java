/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;
import modelo.*;
import persistencia.veterinarioDAO;

/**
 *
 * @author Usuario
 */
public class veterinarioAction extends ActionSupport {
    
    public veterinarioAction() {
    }
    
    private String boton;
    private String dni;
    private String nombre;
    private String especialidad;
    private int experiencia;
    private int telefono;
    private String correo;
    private String password;
    private List<Cita> citasVeterinario;
    private List<Veterinario> listaVeterinarios;
    private String dniVeterinario;
    
    public String getIdVeterinario() {
        return dniVeterinario;
    }
    
    public void setIdVeterinario(String idVeterinario) {
        this.dniVeterinario = idVeterinario;
    }
    
    public List<Veterinario> getListaVeterinarios() {
        return listaVeterinarios;
    }
    
    public void setListaVeterinarios(List<Veterinario> listaVeterinarios) {
        this.listaVeterinarios = listaVeterinarios;
    }
    
    public String getBoton() {
        return boton;
    }
    
    public void setBoton(String boton) {
        this.boton = boton;
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
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public int getExperiencia() {
        return experiencia;
    }
    
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Cita> getCitasVeterinario() {
        return citasVeterinario;
    }
    
    public void setCitasVeterinario(List<Cita> citasVeterinario) {
        this.citasVeterinario = citasVeterinario;
    }
    
    public String execute() throws Exception {
        System.out.println("Valor de boton: " + boton); // Para depuración
        veterinarioDAO dao = new veterinarioDAO();
        Map<String, Object> session = ActionContext.getContext().getSession();
        
        switch (boton) {
            case "Modificar Datos":
                return "modificarDatos";
            
            case "Consultar Agenda":
                // dniVeterinario = dni;
                //Map<String, Object> session = ActionContext.getContext().getSession();
                Veterinario v = (Veterinario) session.get("veterinario");
                citasVeterinario = dao.obtenerCitas(v.getDni());
                return "consultarAgenda";
            
            case "Consultar Compañeros":
                listaVeterinarios = dao.obtenerCompañeros();
                return "consultarCompañeros";
            
            case "Baja Veterinario":
                return "bajaVeterinario";
            
            case "registro":
                Veterinario veterinario = new Veterinario(dni, nombre, especialidad, experiencia, telefono, correo, password);
                dao.altaVeterinario(veterinario);
                listaVeterinarios = dao.obtenerCompañeros();
                return "nuevoRegistro";
            
            case "Modificacion":
                veterinario = dao.obtenerVeterinario(dni);
                veterinario = (Veterinario) session.get("veterinario");
                veterinario.setEspecialidad(this.getEspecialidad());
                veterinario.setExperiencia(this.getExperiencia());
                veterinario.setTelefono(this.getTelefono());
                veterinario.setCorreo(this.getCorreo());
                veterinario.setPassword(this.getPassword());
                dao.modificarVeterinario(veterinario);
                
                return "modificacionVeterinario";
            
            case "LogOut":
                return "salir";
            
            case "Volver":
                return "volver";
            
            case "Gestión Recetas":
                return "gestionRecetas";
            
            case "Generar Factura":
                return "generarFactura";
            
            case "Ver Paciente":
                return "verPaciente";
            
            case "Alta Tratamiento":
                return "altaTratamiento";
            
            case "Alta Receta":
                return "altaReceta";
            
            case "Alta Medicamento":
                return "altaMedicamento";
            
            case "Gestión Medicamentos":
                return "gestionMedicamentos";
            
            case "Cancelar":
                return "cancelar";
            
            case "Dar de Baja":
                veterinario = dao.obtenerVeterinarioBaja(dni, password);
                dao.eliminarVeterinario(veterinario);
                listaVeterinarios = dao.obtenerCompañeros();
                return "eliminar";
            
            default:
                
                return SUCCESS;
            
        }
    }
    
}
