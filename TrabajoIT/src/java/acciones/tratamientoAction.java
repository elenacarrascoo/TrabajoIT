package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Cita;
import modelo.Tratamiento;
import persistencia.citaDAO;
import persistencia.tratamientoDAO;

/**
 *
 * @author Usuario
 */
public class tratamientoAction extends ActionSupport {

    private String boton;
    private int idTratamiento;
    private Cita cita;
    private String tipo;
    private String fecha;
    private double precio;
    private String resultados;
    private List<Tratamiento> listaTratamientos;
    private int idCita;
    private Date fechaFormateada;
    private Date fechaFormateada1;

    public Date getFechaFormateada1() {
        return fechaFormateada1;
    }

    public void setFechaFormateada1(Date fechaFormateada1) {
        this.fechaFormateada1 = fechaFormateada1;
    }
    
    

    public List<Tratamiento> getListaTratamientos() {
        return listaTratamientos;
    }

    public void setListaTratamientos(List<Tratamiento> listaTratamientos) {
        this.listaTratamientos = listaTratamientos;
    }

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Date getFechaFormateada() {
        return fechaFormateada;
    }

    public void setFechaFormateada(Date fechaFormateada) {
        this.fechaFormateada = fechaFormateada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public tratamientoAction() {
    }

    public String execute() throws Exception {
        tratamientoDAO dao = new tratamientoDAO();
        citaDAO daocita = new citaDAO();

        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("idCita", idCita);
        Cita c = daocita.obtenerCita(this.getIdCita());
        Tratamiento tratamiento = new Tratamiento();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        switch (boton) {

            case "Registrar Tratamiento":
                fechaFormateada = formatoFecha.parse(this.getFecha());
                tratamiento = new Tratamiento(this.getTipo(), fechaFormateada, this.getPrecio(), this.getResultados());
                dao.crearTratamiento(tratamiento);
                Cita cSession = (Cita) session.get("c");
                cSession.setTratamiento(tratamiento);
                daocita.actualizarCita(cSession);
                session.remove("c");
                return "registro";

            case "Consultar Tratamientos":
                listaTratamientos = dao.obtenerTodosLosTratamientos();
                return "verTratamientos";

            case "Modificar":
                return "modificacion";

            case "Modificacion":
                tratamiento = dao.obtenerTratamiento(idTratamiento);

                if (tratamiento != null) {
                    tratamiento = (Tratamiento) session.get("tratamiento");
                    tratamiento.setTipo(this.getTipo());
                    fechaFormateada1 = formatoFecha.parse(this.getFecha());
                    tratamiento.setFecha(fechaFormateada1);
                    tratamiento.setPrecio(this.getPrecio());
                    tratamiento.setResultados(this.getResultados());
                    dao.actualizarTratamiento(tratamiento);
                    listaTratamientos = dao.obtenerTodosLosTratamientos();
                    return "modificacionCompletada";

                }
                
            case "Volver a Opciones":
                return "opciones";

            case "Eliminar":
                
                tratamiento = dao.obtenerTratamiento(idTratamiento);
                dao.eliminarTratamiento(tratamiento);
                listaTratamientos = dao.obtenerTodosLosTratamientos();

                return "eliminacion_completada";

            case "Volver a Agenda":
                return "retorno";

            case "Volver":
                return "volver";

            case "LogOut":
                return "volver";
            default:
                return SUCCESS;
        }

    }

    public void validate() {
        // Validaciones para la acción de registro o modificación
        if ("Registrar Tratamiento".equalsIgnoreCase(boton) || "Modificar Tratamiento".equalsIgnoreCase(boton)) {

            // Validar tipo (no vacío, uno de los valores permitidos)
            if (this.getTipo().isEmpty()) {
                addFieldError("tipo", "Introduce el tipo de tratamiento");

            }

            // Validar fecha (debe ser válida y en formato 'dd/MM/yyyy')
            if (this.getFecha() == null) {
                addFieldError("fecha", "Introduce una fecha válida");
            }

            // Validar precio (debe ser positivo)
            if (this.getPrecio() < 0) {
                addFieldError("precio", "El precio debe ser un número positivo");
            }

            // Validar resultados (no vacío, solo letras y espacios)
            String patronResultados = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$";
            Pattern pattern = Pattern.compile(patronResultados);
            Matcher matcher = pattern.matcher(this.getResultados());

            if (this.getResultados().isEmpty()) {
                addFieldError("resultados", "Introduce los resultados");
            } else if (!matcher.matches()) {
                addFieldError("resultados", "Los resultados solo pueden contener letras y espacios");
            }
        }
    }

}
