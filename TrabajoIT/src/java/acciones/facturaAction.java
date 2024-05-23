/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.Cita;
import modelo.Factura;
import modelo.Paciente;
import modelo.Propietario;
import persistencia.facturaDAO;
import persistencia.pacienteDAO;
import persistencia.propietarioDAO;

/**
 *
 * @author ecarr
 */
public class facturaAction extends ActionSupport {

    private Integer numFactura;
    private Propietario propietario;
    private Date fecha;
    private double importe;
    private List<Cita> citas= new ArrayList<Cita>();

    public facturaAction() {
    }

    public Integer getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(Integer numFactura) {
        this.numFactura = numFactura;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public String execute() throws Exception {
        facturaDAO fdao = new facturaDAO();
        Factura f = new Factura(this.getPropietario(), this.getFecha(), this.getImporte(), (Set) this.getCitas());
        fdao.altaFactura(f);
        return SUCCESS;
    }

    public String actualizarFactura() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        Factura f = (Factura) session.get("factura");//Tengo que ponerla en al sesion
        f.setImporte(this.getImporte());
        return SUCCESS;
    }
    
    public String modificarFactura(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        facturaDAO f = new facturaDAO();
        Factura facturaModificar = f.obtenerFactura(this.getNumFactura());

        facturaModificar.setImporte(this.getImporte());
        f.actualizarFactura(facturaModificar);
        return SUCCESS;
    }
    
    public String eliminarFactura() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        facturaDAO f = new facturaDAO();
        Factura facturaEliminar = f.obtenerFactura(this.getNumFactura());
        f.bajaFactura(facturaEliminar);
        return SUCCESS;
    }
    
    public String consultarFactura(){
        facturaDAO fdao = new facturaDAO();
        Factura f = fdao.obtenerFactura(this.getNumFactura());
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("factura", f);
        return SUCCESS;
    }
        
    
   
}
