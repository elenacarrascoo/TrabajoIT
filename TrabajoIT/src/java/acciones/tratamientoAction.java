/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import modelo.Tratamiento;
import persistencia.tratamientoDAO;

/**
 *
 * @author Usuario
 */
public class tratamientoAction extends ActionSupport {

    private String boton;
    private List<Tratamiento> listaTratamientos;
    private Integer id;
    private Date fecha;
    private Date hora;
    private double precio;
    private String resultados;
    private String tipo;
    private int idCita;

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public List<Tratamiento> getListaTratamientos() {
        return listaTratamientos;
    }

    public void setListaTratamientos(List<Tratamiento> listaTratamientos) {
        this.listaTratamientos = listaTratamientos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

        switch (boton) {
            case "Registrar Tratamiento":
                Tratamiento tratamiento = new Tratamiento(fecha, hora, precio, resultados, tipo, idCita);
                dao.crearTratamiento(tratamiento);
                listaTratamientos = dao.obtenerTodosLosTratamientos();
                return "registro";
                
            case "Ver Tratamientos":
                tratamiento = dao.obtenerTratamiento(idCita);
                return "consultar";
                
                
            case "Volver":
                return "volver";
                
                
            case "LogOut":
                return "volver";
                 default:
                    return SUCCESS;
        }
      
    }

}
