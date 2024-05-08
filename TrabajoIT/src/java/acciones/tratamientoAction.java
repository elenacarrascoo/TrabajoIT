/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
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

        switch (boton) {
            case "Registrar Tratamiento":
                Tratamiento tratamiento = new Tratamiento(id, cita, tipo, fecha, precio, resultados);
                dao.crearTratamiento(tratamiento);
                listaTratamientos = dao.obtenerTodosLosTratamientos();

                return "registro";

            case "Volver":
                return "volver";

            case "LogOut":
                return "volver";
            default:
                return SUCCESS;
        }

    }

}
