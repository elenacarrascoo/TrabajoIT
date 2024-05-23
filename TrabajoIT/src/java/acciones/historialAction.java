/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.Cita;
import modelo.Historial;
import modelo.Paciente;
import modelo.Propietario;
import modelo.Veterinario;
import persistencia.citaDAO;
import persistencia.historialDAO;
import persistencia.pacienteDAO;

/**
 *
 * @author ecarr
 */
public class historialAction extends ActionSupport {
 
    int id;
    int historialConsultar;
    int pacienteConsultar;
    private List<Cita> listaCitas;
    private List<Historial> historialPaciente;
    private String boton;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHistorialConsultar() {
        return historialConsultar;
    }

    public void setHistorialConsultar(int historialConsultar) {
        this.historialConsultar = historialConsultar;
    }

    public int getPacienteConsultar() {
        return pacienteConsultar;
    }

    public void setPacienteConsultar(int pacienteConsultar) {
        this.pacienteConsultar = pacienteConsultar;
    }

    public List<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }
    
    public historialAction() {
    }

    public List<Historial> getHistorialPaciente() {
        return historialPaciente;
    }

    public void setHistorialPaciente(List<Historial> historialPaciente) {
        this.historialPaciente = historialPaciente;
    }

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }
    
    public String execute() throws Exception {
        if(boton.equalsIgnoreCase("volver")){
            return "propietarioPaciente";
        }else if(boton.equalsIgnoreCase("logout")){
            return "salir";
        }
        return SUCCESS;
    }
    
    public String verHistorialPaciente(){
       Map<String, Object> session = ActionContext.getContext().getSession();
       historialDAO h = new historialDAO();
       pacienteDAO p = new pacienteDAO();
       Paciente paciente = p.obtenerPaciente(this.getPacienteConsultar());
       List<Historial> historialPaciente = h.obtenerHistorialPaciente(paciente);
       this.setHistorialPaciente(historialPaciente);
       return SUCCESS;
    }
    
    public String modificarHistorial(){
       //Map<String, Object> session = ActionContext.getContext().getSession();
       historialDAO h = new historialDAO();
       pacienteDAO p = new pacienteDAO();
       Paciente paciente = p.obtenerPaciente(this.getPacienteConsultar());
       List<Historial> historialModificar = h.obtenerHistorialPaciente(paciente);
       //No se si es ese id el que hay quye pasarle
       
       return SUCCESS;
    }
    
    public String eliminarHistorial(){
       //Map<String, Object> session = ActionContext.getContext().getSession();
       historialDAO daoh = new historialDAO();
       pacienteDAO p = new pacienteDAO();
       Paciente paciente = p.obtenerPaciente(this.getPacienteConsultar());
       List<Historial> historialEliminar = daoh.obtenerHistorialPaciente(paciente);
       for (int i = 0; i < historialEliminar.size(); i++) {
            daoh.bajaHistorial(historialEliminar.get(i));
        }
       //No se si es ese id el que hay quye pasarle
       return SUCCESS;
    }
    

    
}
