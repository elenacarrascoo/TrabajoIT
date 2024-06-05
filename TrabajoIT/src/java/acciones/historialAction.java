package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import modelo.Cita;
import modelo.Historial;
import modelo.Paciente;
import persistencia.citaDAO;
import persistencia.historialDAO;
import persistencia.pacienteDAO;

/**
 *
 * @author ecarr
 */
public class historialAction extends ActionSupport {
 
    int idCita;
    int historialConsultar;
    int pacienteConsultar;
    private List<Cita> listaCitas;
    private List<Historial> historialPaciente;
    private String boton;

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
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
       Integer id = (Integer) session.get("id");
       
       if(id != null){
       historialDAO h = new historialDAO();
       citaDAO cdao = new citaDAO();
        Paciente p = h.obtenerPacienteIdCita(cdao.obtenerCita(this.getIdCita()));
       session.put("paciente",p);
       List<Historial> historialPaciente = h.obtenerHistorialPaciente(p);
       this.setHistorialPaciente(historialPaciente);
       }
       return SUCCESS;
    } 

    
}
