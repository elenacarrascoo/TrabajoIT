/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import modelo.Cita;
import persistencia.citaDAO;

/**
 *
 * @author ecarr
 */
public class citaAction extends ActionSupport {
 
    int idCitaModificar;
    
    int pacienteConsultar;
    int historialPacienteConsultar;
    
    int numHistorial;
    
    String fecha;
    String hora;
    String motivo;

    public int getIdCitaModificar() {
        return idCitaModificar;
    }

    public void setIdCitaModificar(int idCitaModificar) {
        this.idCitaModificar = idCitaModificar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getPacienteConsultar() {
        return pacienteConsultar;
    }

    public void setPacienteConsultar(int pacienteConsultar) {
        this.pacienteConsultar = pacienteConsultar;
    }

    public int getHistorialPacienteConsultar() {
        return historialPacienteConsultar;
    }

    public void setHistorialPacienteConsultar(int historialPacienteConsultar) {
        this.historialPacienteConsultar = historialPacienteConsultar;
    }

    public int getNumHistorial() {
        return numHistorial;
    }

    public void setnumHistorial(int numHistorial) {
        this.numHistorial = numHistorial;
    }
    
    public citaAction() {
    }
    
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String altaCita() throws ParseException{
        citaDAO c = new citaDAO();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-mm-dd");
        Date fechaFormateada = formatoFecha.parse(this.getFecha());
       
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH-MM-SS");
        Date horaFormateada = formatoHora.parse(this.getHora());
        //Falta asignar como asingar el veterinario
        Cita cita = new Cita(fechaFormateada, horaFormateada, this.getMotivo(), this.getNumHistorial(), null);
        c.altaCita(cita);
        return SUCCESS;
    }
    
    public String citasPendientes(){  
       Map<String, Object> session = ActionContext.getContext().getSession();
       citaDAO c = new citaDAO();

       Date fecha = new Date();
       Date hora = new Date();   
       
       // Revisar tipos de hora y fecha con la BBDD
       List<Cita> citasPendientes = c.obtenerCitasPendientes(this.getHistorialPacienteConsultar(), fecha, hora);
       
       session.put("citasPendientes", citasPendientes);
       return SUCCESS;
    }
    
    public String modificarCita() throws ParseException{
       Map<String, Object> session = ActionContext.getContext().getSession();
       citaDAO c = new citaDAO();
       Cita citaModificar = c.obtenerCita(this.getIdCitaModificar());
       
       SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-mm-dd");
       Date fechaFormateada = formatoFecha.parse(this.getFecha());
       
       SimpleDateFormat formatoHora = new SimpleDateFormat("HH-MM-SS");
       Date horaFormateada = formatoHora.parse(this.getHora());
       
       citaModificar.setHora(fechaFormateada);
       citaModificar.setFecha(horaFormateada);
       citaModificar.setMotivo(this.getMotivo());
       c.actualizarCita(citaModificar);
       return SUCCESS;
    }
    
    public String eliminarCita(){
       Map<String, Object> session = ActionContext.getContext().getSession();
       citaDAO c = new citaDAO();
       Cita citaEliminar = c.obtenerCita(this.getIdCitaModificar()); 
       c.bajaCita(citaEliminar);
       return SUCCESS;
    }
    
}
