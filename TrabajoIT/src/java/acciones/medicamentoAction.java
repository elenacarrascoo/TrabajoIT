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
        session.remove("cita");
        return SUCCESS;
    }
    
    public String consultarMedicamento(){
        medicamentoDAO mdao = new medicamentoDAO();
        List<Medicamento> medicamentos = mdao.obtenerMedicamentos();
        setMedicamentos(medicamentos);
        return SUCCESS;
    }
}
