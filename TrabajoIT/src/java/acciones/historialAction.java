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
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String verHistorialPaciente(){
       Map<String, Object> session = ActionContext.getContext().getSession();
       historialDAO h = new historialDAO();
       pacienteDAO p = new pacienteDAO();
       Paciente paciente = p.obtenerPaciente(this.getPacienteConsultar());
       Historial historialPaciente = h.obtenerHistorialPaciente(paciente);
       session.put("historialPaciente", historialPaciente);
       listarCitasHistorial();
       return SUCCESS;
    }
    
    public String modificarHistorial(){
       Map<String, Object> session = ActionContext.getContext().getSession();
       historialDAO h = new historialDAO();
       pacienteDAO p = new pacienteDAO();
       Paciente paciente = p.obtenerPaciente(this.getPacienteConsultar());
       Historial historialModificar = h.obtenerHistorialPaciente(paciente);
       //No se si es ese id el que hay quye pasarle
       
       return SUCCESS;
    }
    
    public String eliminarHistorial(){
       Map<String, Object> session = ActionContext.getContext().getSession();
       historialDAO h = new historialDAO();
       pacienteDAO p = new pacienteDAO();
       Paciente paciente = p.obtenerPaciente(this.getPacienteConsultar());
       Historial historialEliminar = h.obtenerHistorialPaciente(paciente);
       h.bajaHistorial(historialEliminar);
       //No se si es ese id el que hay quye pasarle
       return SUCCESS;
    }
    
    public String listarCitasHistorial(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        citaDAO cDAO = new citaDAO();
        Historial h = (Historial) session.get("historialPaciente");
        List<Cita> listaCitas = cDAO.obtenerCitasHistorial(h);
        this.setListaCitas(listaCitas);
        return SUCCESS;
    }
    
}
