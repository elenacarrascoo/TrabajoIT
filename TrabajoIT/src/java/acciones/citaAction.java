package acciones;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cita;
import modelo.Factura;
import modelo.Historial;
import modelo.Paciente;
import modelo.Propietario;
import modelo.Veterinario;
import persistencia.citaDAO;
import persistencia.facturaDAO;
import persistencia.historialDAO;
import persistencia.pacienteDAO;
import persistencia.veterinarioDAO;

/**
 *
 * @author ecarr
 */
public class citaAction extends ActionSupport {

    int idCitaModificar;

    int pacienteConsultar;
    List<Historial> historialConsultar;

    int idPaciente;

    Veterinario veterinario;
    Veterinario veterinarioSeleccionado;
    List<Veterinario> veterinariosDisponibles;
    List<String> veterinarios;
    String veterinarioDisponible;

    String fecha;
    String hora;
    String motivo;
    String boton;

    List<Cita> citasPendientes;

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

    public List<Historial> getHistorialConsultar() {
        return historialConsultar;
    }

    public void setHistorialConsultar(List<Historial> historialConsultar) {
        this.historialConsultar = historialConsultar;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public List<Cita> getCitasPendientes() {
        return citasPendientes;
    }

    public void setCitasPendientes(List<Cita> citasPendientes) {
        this.citasPendientes = citasPendientes;
    }

    public List<Veterinario> getVeterinariosDisponibles() {
        return veterinariosDisponibles;
    }

    public void setVeterinariosDisponibles(List<Veterinario> veterinariosDisponibles) {
        this.veterinariosDisponibles = veterinariosDisponibles;
    }

    public Veterinario getVeterinarioSeleccionado() {
        return veterinarioSeleccionado;
    }

    public void setVeterinarioSeleccionado(Veterinario veterinarioSeleccionado) {
        this.veterinarioSeleccionado = veterinarioSeleccionado;
    }

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public List<String> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(List<String> veterinarios) {
        this.veterinarios = veterinarios;
    }

    public String getVeterinarioDisponible() {
        return veterinarioDisponible;
    }

    public void setVeterinarioDisponible(String veterinarioDisponible) {
        this.veterinarioDisponible = veterinarioDisponible;
    }

    public citaAction() {
    }

    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("idPaciente", this.getIdPaciente());
        veterinarioDAO vdao = new veterinarioDAO();
        List<String> veterinarios = vdao.listadoVeterinarios();
        this.setVeterinarios(veterinarios);
        return SUCCESS;
    }

    Random random = new Random();

    public String altaCita() throws ParseException {
        Map<String, Object> session = ActionContext.getContext().getSession();

        citaDAO c = new citaDAO();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy-MM-dd");
        Date fechaFormateada = formatoFecha.parse(this.getFecha());

        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        Date hora = formatoHora.parse(this.getHora());

        veterinarioDAO vdao = new veterinarioDAO();
        Veterinario v = vdao.obtenerVeterinarioNombre(this.getVeterinarioDisponible());

        Random random = new Random();
        int importeFactura = random.nextInt((99 - 0) + 1) + 0;
        Factura f = new Factura((Propietario) session.get("propietario"), new Date(), importeFactura);
        facturaDAO fdao = new facturaDAO();
        fdao.altaFactura(f);
        Cita cita = new Cita(f, v, fechaFormateada, hora, this.getMotivo());
        c.altaCita(cita);

        pacienteDAO pdao = new pacienteDAO();
        Paciente paciente = pdao.obtenerPaciente((int) session.get("idPaciente"));
        Historial h = new Historial(cita, paciente);
        historialDAO hdao = new historialDAO();
        hdao.altaHistorial(h);

        Date fechaHoraActual = new Date();

        SimpleDateFormat formatoF = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoH = new SimpleDateFormat("HH:mm:ss");

        String fechaActualStr = formatoF.format(fechaHoraActual); // Solo la fecha
        String horaActualStr = formatoH.format(fechaHoraActual); // Solo la hora

        Date fechaActual = formatoFecha.parse(fechaActualStr);
        Date horaActual = formatoHora.parse(horaActualStr);

        List<Cita> citasPendientes = c.obtenerCitas(paciente, fechaActual, horaActual);
        this.setCitasPendientes(citasPendientes);

        Propietario p = (Propietario) session.get("propietario");
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String fechaString = formater.format(cita.getFecha());
        SimpleDateFormat formaterHora = new SimpleDateFormat("HH:mm:ss");
        String horaString = formaterHora.format(cita.getHora());
        enviarCorreo(p.getCorreo(), fechaString, horaString, cita.getMotivo(), importeFactura);

        session.remove("idPaciente");
        return SUCCESS;
    }

    public String opciones() {
        if (boton.equalsIgnoreCase("volver")) {
            return "propietarioPaciente";
        } else if (boton.equalsIgnoreCase("volver")) {
            return "salir";
        }
        return SUCCESS;
    }

    public String obtenerVeterinarios() {
        veterinarioDAO vDAO = new veterinarioDAO();
        setVeterinariosDisponibles(vDAO.obtenerCompañeros());
        return SUCCESS;
    }

    public String citasPendientes() throws ParseException {
        Date fechaHoraActual = new Date();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        String fechaActualStr = formatoFecha.format(fechaHoraActual); // Solo la fecha
        String horaActualStr = formatoHora.format(fechaHoraActual); // Solo la hora

        Date fechaActual = formatoFecha.parse(fechaActualStr);
        Date horaActual = formatoHora.parse(horaActualStr);

        pacienteDAO pdao = new pacienteDAO();
        Paciente p = pdao.obtenerPaciente(this.getPacienteConsultar());

        citaDAO cdao = new citaDAO();
        List<Cita> citasPendientes = cdao.obtenerCitas(p, fechaActual, horaActual);
        this.setCitasPendientes(citasPendientes);

        return SUCCESS;
    }

    public String modificarCita() throws ParseException {

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

    public String eliminarCita() throws ParseException {
        citaDAO c = new citaDAO();
        Cita citaEliminar = c.obtenerCita(this.getIdCitaModificar());
        c.bajaCita(citaEliminar);
        return SUCCESS;
    }

    public void validate() {
        String actionName = ActionContext.getContext().getName();

        if (actionName.equals("altaCita") || actionName.equals("modificarCita")) {

            if (this.getFecha().equals("")) {
                addFieldError("fecha", getText("fecha.requerido"));
            } else {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-mm-dd");
                formatoFecha.setLenient(false);
                try {
                    formatoFecha.parse(this.getFecha());
                } catch (ParseException e) {
                    addFieldError("fecha", getText("fecha.formato"));
                }
            }

            if (this.getHora().equals("")) {
                addFieldError("hora", getText("hora.requerido"));
            } else {
                // Validar formato de hora
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                formatoHora.setLenient(false);
                try {
                    formatoHora.parse(this.getHora());
                } catch (ParseException e) {
                    addFieldError("hora", getText("hora.formato"));
                }
            }

            if (this.getMotivo().equals("")) {
                addFieldError("motivo", getText("motivo.requerido"));
            }

            veterinarioDAO vdao = new veterinarioDAO();
            Veterinario v = vdao.obtenerVeterinarioNombre(this.getVeterinarioDisponible());
            List<Cita> citasVeterinario = vdao.obtenerCitas(v.getDni());

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            boolean enc=false;
            try {
                for (Cita cita : citasVeterinario) {
                    System.out.println(cita.getFecha());
                    System.out.println(formatoFecha.parse(this.getFecha()));
                    if (cita.getFecha().equals(formatoFecha.parse(this.getFecha()))) {
                        
                        Date hora = cita.getHora();
                        Date horaCita = formatoHora.parse(this.getHora());

                        long diferenciaEnMilisegundos = Math.abs(hora.getTime() - horaCita.getTime());
                        long diferenciaEnMinutos = diferenciaEnMilisegundos / (1000 * 60);

                        System.out.println(diferenciaEnMinutos);

                        if (diferenciaEnMinutos < 30) {
                            enc=true;
                        }

                    }

                }
            } catch (ParseException ex) {
                Logger.getLogger(citaAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(enc){
                addFieldError("hora", "Veterinario ocupado en esa hora. Pruebe media hora mas tarde");
            }
            
        }
        veterinarioDAO vdao = new veterinarioDAO();
        List<String> veterinarios = vdao.listadoVeterinarios();
        this.setVeterinarios(veterinarios);

    }

    private static void enviarCorreo(java.lang.String destinatario, java.lang.String fecha, java.lang.String hora, java.lang.String motivo, int importeFactura) {
        misservicios.CorreoWS_Service service = new misservicios.CorreoWS_Service();
        misservicios.CorreoWS port = service.getCorreoWSPort();
        port.enviarCorreo(destinatario, fecha, hora, motivo, importeFactura);
    }

}
