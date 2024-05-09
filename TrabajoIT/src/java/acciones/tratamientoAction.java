/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Cita;
import modelo.Tratamiento;
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
    private Date fecha;
    private double precio;
    private String resultados;
    private List<Tratamiento> listaTratamientos;
    private int idCita;

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public tratamientoAction() {
    }

    public String execute() throws Exception {
        tratamientoDAO dao = new tratamientoDAO();
        Map<String, Object> session = ActionContext.getContext().getSession();

        switch (boton) {
            case "Registrar Tratamiento":
                Tratamiento tratamiento = new Tratamiento(id, cita, tipo, fecha, precio, resultados);
                dao.crearTratamiento(tratamiento);
                listaTratamientos = dao.obtenerTodosLosTratamientos();

                return "registro";
                
            case "Consultar Tratamientos":
                listaTratamientos = dao.obtenerTodosLosTratamientos();
                return "verTratamientos";
                
            case "Modificar Tratamiento":
                return "modificacion";
                
                
            case"Modificar":
                tratamiento = (Tratamiento) session.get("tratamiento");
                tratamiento.setTipo(this.getTipo());
                tratamiento.setFecha(this.getFecha());
                tratamiento.setPrecio(this.getPrecio());
                tratamiento.setResultados(this.getResultados());
                dao.actualizarTratamiento(tratamiento);
                listaTratamientos = dao.obtenerTodosLosTratamientos();
                return "modificacionCompletada";
                
            case "Eliminar Tratamiento":
                tratamiento = dao.obtenerTratamiento(idCita);
                dao.eliminarTratamiento(tratamiento);
                listaTratamientos = dao.obtenerTodosLosTratamientos();
                return "eliminacion";
            

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
            } else {
                String[] tiposValidos = {"TipoA", "TipoB", "TipoC"}; // Ajusta según tus valores válidos
                boolean tipoValido = false;
                for (String t : tiposValidos) {
                    if (this.getTipo().equalsIgnoreCase(t)) {
                        tipoValido = true;
                        break;
                    }
                }
                if (!tipoValido) {
                    addFieldError("tipo", "Tipo no válido");
                }
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
