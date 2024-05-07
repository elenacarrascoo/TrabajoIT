/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import static java.lang.Math.random;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import modelo.Cita;
import modelo.Historial;
import modelo.Veterinario;
import persistencia.citaDAO;

/**
 *
 * @author ecarr
 */
public class citaAction extends ActionSupport {

    int idCitaModificar;

    int pacienteConsultar;
    Historial historialPacienteConsultar;

    int numHistorial;
    //No estoy seguro de que asi
    Veterinario veterinario;

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

    public Historial getHistorialPacienteConsultar() {
        return historialPacienteConsultar;
    }

    public void setHistorialPacienteConsultar(Historial historialPacienteConsultar) {
        this.historialPacienteConsultar = historialPacienteConsultar;
    }

    public int getNumHistorial() {
        return numHistorial;
    }

    public void setNumHistorial(int numHistorial) {
        this.numHistorial = numHistorial;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    

    public citaAction() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    Random random = new Random();
    public String altaCita() throws ParseException {
        citaDAO c = new citaDAO();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy-MM-dd");
        Date fechaFormateada = formatoFecha.parse(this.getFecha());

        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        Date hora = formatoHora.parse(this.getHora());
        
        //Falta asignar como asingar el veterinario
        //Ver lo de Id Cita
        Cita cita = new Cita(random.nextInt(),this.getHistorialPacienteConsultar(), this.getVeterinario(), fechaFormateada, hora, this.getMotivo());
        c.altaCita(cita);
        return SUCCESS;
    }

    public String citasPendientes() throws ParseException {
        Map<String, Object> session = ActionContext.getContext().getSession();
        citaDAO c = new citaDAO();

        Date fechaHoraActual = new Date();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        String fechaActualStr = formatoFecha.format(fechaHoraActual); // Solo la fecha
        String horaActualStr = formatoHora.format(fechaHoraActual); // Solo la hora
        
        Date fechaActual = formatoFecha.parse(fechaActualStr); 
        Date horaActual = formatoHora.parse(horaActualStr);   
        
        // Revisar tipos de hora y fecha con la BBDD
        List<Cita> citasPendientes = c.obtenerCitasPendientes(this.getHistorialPacienteConsultar().getNumHistorial(), fechaActual, horaActual);

        session.put("citasPendientes", citasPendientes);
        return SUCCESS;
    }

    public String modificarCita() throws ParseException {
        Map<String, Object> session = ActionContext.getContext().getSession();
        citaDAO c = new citaDAO();
        Cita citaModificar = c.obtenerCita(this.getIdCitaModificar());

        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-mm-dd");
        Date fechaFormateada = formatoFecha.parse(this.getFecha());

        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        Date horaFormateada = formatoHora.parse(this.getHora());

        citaModificar.setHora(fechaFormateada);
        citaModificar.setFecha(horaFormateada);
        citaModificar.setMotivo(this.getMotivo());
        c.actualizarCita(citaModificar);
        return SUCCESS;
    }

    public String eliminarCita() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        citaDAO c = new citaDAO();
        Cita citaEliminar = c.obtenerCita(this.getIdCitaModificar());
        c.bajaCita(citaEliminar);
        return SUCCESS;
    }
    

    public void validate() {
        String actionName = ActionContext.getContext().getName();

        if (actionName.equals("altaCita") || actionName.equals("modificarCita")) {
            
            if (this.getFecha().equals("")) {
                addFieldError("fecha", "Introduce la fecha");
            } else {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-mm-dd");
                formatoFecha.setLenient(false);
                try {
                    formatoFecha.parse(this.getFecha());
                } catch (ParseException e) {
                    addFieldError("fecha", "Formato de fecha inválido. Utiliza YYYY-mm-dd.");
                }
            }

            if (this.getHora().equals("")) {
                addFieldError("hora", "Introduce la hora");
            } else {
                // Validar formato de hora
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                formatoHora.setLenient(false);
                try {
                    formatoHora.parse(this.getHora());
                } catch (ParseException e) {
                    addFieldError("hora", "Formato de hora inválido. Utiliza HH:mm:ss.");
                }
            }

            if (this.getMotivo().equals("")) {
                addFieldError("motivo", "Introduce el motivo");
            }

        }
    }

}
