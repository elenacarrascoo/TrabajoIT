/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import modelo.Cita;
import modelo.Medicamento;
import persistencia.citaDAO;
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
    private int idCita;
    private List<Medicamento> medicamentos;
    private int idMedicamentoEliminar;
    private int idMedicamentoModificar;
    private String medicamento;
    private String boton;
    
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

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public int getIdMedicamentoEliminar() {
        return idMedicamentoEliminar;
    }

    public void setIdMedicamentoEliminar(int idMedicamentoEliminar) {
        this.idMedicamentoEliminar = idMedicamentoEliminar;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public int getIdMedicamentoModificar() {
        return idMedicamentoModificar;
    }

    public void setIdMedicamentoModificar(int idMedicamentoModificar) {
        this.idMedicamentoModificar = idMedicamentoModificar;
    }
    
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        citaDAO cdao = new citaDAO();
        Cita c = cdao.obtenerCita(this.getIdCita());
        session.put("cita", c);
        return SUCCESS;
    }
    
    public String altaMedicamento() throws ParseException{
        Map<String, Object> session = ActionContext.getContext().getSession();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy-MM-dd");
        Date fechaFormateada = formatoFecha.parse(this.getFechaCaducidad());
        Medicamento m = new Medicamento(this.getNombre(), fechaFormateada);
        medicamentoDAO mdao = new medicamentoDAO();
        mdao.altaMedicamento(m);
        Cita c = (Cita) session.get("cita");
        c.setMedicamento(m);
        citaDAO cdao = new citaDAO();
        cdao.actualizarCita(c);
        session.remove("cita");
        return SUCCESS;
    }
    
    public String formActualizarMedicamento(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        medicamentoDAO mdao = new medicamentoDAO();
        Medicamento m = mdao.obtenerMedicamento(this.idMedicamentoModificar);
        session.put("medicamentoModificar", m);
        return SUCCESS;
    }
    
    public String actualizarMedicamento() throws ParseException{
        Map<String, Object> session = ActionContext.getContext().getSession();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy-MM-dd");
        Date fechaFormateada = formatoFecha.parse(this.getFechaCaducidad());
        medicamentoDAO daoM = new medicamentoDAO();
        Medicamento m = (Medicamento) session.get("medicamentoModificar");
        m.setNombre(this.getNombre());
        m.setFechaCaducidad(fechaFormateada);
        daoM.actualizarMedicamento(m);
        return SUCCESS;
    }
    /* 
    
    public String modificarMedicamento() throws ParseException{
        Map<String, Object> session = ActionContext.getContext().getSession();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy-MM-dd");
        Date fechaFormateada = formatoFecha.parse(this.getFechaCaducidad());
        medicamentoDAO daoM = new medicamentoDAO();
        Medicamento m = (Medicamento) session.get("pacienteAModificar");
        m.setNombre(this.getNombre());
        m.setFechaCaducidad(fechaFormateada);
        daoM.actualizarMedicamento(m);
        medicamentos = daoM.obtenerMedicamentos();
        return SUCCESS;
    }
    */
    public String eliminarMedicamento() throws ParseException{
        medicamentoDAO mDAO = new medicamentoDAO();
        Medicamento m = mDAO.obtenerMedicamento(getIdMedicamentoEliminar());
        mDAO.bajaMedicamento(m);
        medicamentos = mDAO.obtenerMedicamentos();
        return SUCCESS;
    }
    
    public String opcionesVolver(){
        if(boton.equalsIgnoreCase("volver")){
            return "agenda";
        }else if(boton.equalsIgnoreCase("logout")){
            return "salir";
        }
        return SUCCESS;
    }
    
    
}
