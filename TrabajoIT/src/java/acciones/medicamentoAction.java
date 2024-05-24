/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Medicamento;
import persistencia.medicamentoDAO;

/**
 *
 * @author ecarr
 */
public class medicamentoAction extends ActionSupport {
    
    public medicamentoAction() {
    }
    
    private String nombre;
    private String fechaCaducidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public String execute() throws Exception {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy-MM-dd");
        Date fechaFormateada = formatoFecha.parse(this.getFechaCaducidad());
        Medicamento m = new Medicamento(this.getNombre(), fechaFormateada);
        medicamentoDAO mdao = new medicamentoDAO();
        mdao.altaMedicamento(m);
        return SUCCESS;
    }
    
}
