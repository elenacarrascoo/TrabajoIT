/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
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
    private int idVeterinario;

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
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

        switch (boton) {
            case "Modificar Datos":
                return "modificarDatos";

            case "Consultar Agenda":
                idVeterinario = 5688767;
                citasVeterinario = dao.obtenerCitas(idVeterinario);
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

            case "modificacion":
                veterinario = dao.obtenerVeterinario(dni);

                if (veterinario == null) {
                    addActionError("Veterinario no encontrado en la base de datos");
                    return ERROR;
                }
                veterinario.setNombre(nombre);
                veterinario.setEspecialidad(especialidad);
                veterinario.setExperiencia(experiencia);
                veterinario.setTelefono(telefono);
                veterinario.setCorreo(correo);

                if (password != null && !password.isEmpty()) {
                    // Solo actualiza la contraseña si se proporciona
                    veterinario.setPassword(password);
                }

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
                
            case"Ver Paciente":
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
               veterinario = dao.obtenerVeterinario(dni);
               dao.eliminarVeterinario(veterinario);
               listaVeterinarios = dao.obtenerCompañeros();
               return "eliminar";
                

            default:

                return SUCCESS;

        }
    }

}
