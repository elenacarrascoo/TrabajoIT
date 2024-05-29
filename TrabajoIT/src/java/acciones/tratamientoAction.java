/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import modelo.Cita;
import modelo.Tratamiento;
import org.apache.struts2.ServletActionContext;
import persistencia.citaDAO;
import persistencia.tratamientoDAO;

/**
 *
 * @author Usuario
 */
public class tratamientoAction extends ActionSupport {

    private String boton;
    private int id;
    private Cita cita;
    private String tipo;
    private String fecha;
    private double precio;
    private String resultados;
    private List<Tratamiento> listaTratamientos;
    private String idCita;
    private Date fechaFormateada;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public tratamientoAction() {
    }

    public String execute() throws Exception {
        tratamientoDAO dao = new tratamientoDAO();
        citaDAO daocita = new citaDAO();

        HttpServletRequest request = ServletActionContext.getRequest();
        idCita = request.getParameter("idCita");

        Map<String, Object> session = ActionContext.getContext().getSession();
        //session.put("idCita", idCita);
        session.put("idCita", idCita);
        Tratamiento tratamiento = new Tratamiento();

        switch (boton) {
            case "Registrar Tratamiento":

                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
                fechaFormateada = formatoFecha.parse(this.getFecha());
                tratamiento = new Tratamiento(tipo, fechaFormateada, precio, resultados);
                dao.crearTratamiento(tratamiento);
                listaTratamientos = dao.obtenerTodosLosTratamientos();

                return "registro";

            case "Consultar Tratamientos":
                listaTratamientos = dao.obtenerTodosLosTratamientos();
                return "verTratamientos";

            case "Modificar Tratamiento":
                return "modificacion";

            case "Modificar":
                tratamiento = (Tratamiento) session.get("tratamiento");
                if (tratamiento != null) {

                    tratamiento.setTipo(this.getTipo());
                    tratamiento.setFecha(fechaFormateada);
                    tratamiento.setPrecio(this.getPrecio());
                    tratamiento.setResultados(this.getResultados());
                    dao.actualizarTratamiento(tratamiento);
                    listaTratamientos = dao.obtenerTodosLosTratamientos();
                    return "modificacionCompletada";

                }

            case "Eliminar Tratamiento":
                tratamiento = (Tratamiento) session.get("tratamiento");
                dao.eliminarTratamiento(tratamiento);
                listaTratamientos = dao.obtenerTodosLosTratamientos();

                return "eliminacion";

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
