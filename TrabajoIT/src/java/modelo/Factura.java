package modelo;
// Generated 21-may-2024 21:28:50 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Factura generated by hbm2java
 */
public class Factura  implements java.io.Serializable {


     private Integer numFactura;
     private Propietario propietario;
     private Date fecha;
     private double importe;
     private Set citas = new HashSet(0);

    public Factura() {
    }

	
    public Factura(Propietario propietario, Date fecha, double importe) {
        this.propietario = propietario;
        this.fecha = fecha;
        this.importe = importe;
    }
    public Factura(Propietario propietario, Date fecha, double importe, Set citas) {
       this.propietario = propietario;
       this.fecha = fecha;
       this.importe = importe;
       this.citas = citas;
    }
   
    public Integer getNumFactura() {
        return this.numFactura;
    }
    
    public void setNumFactura(Integer numFactura) {
        this.numFactura = numFactura;
    }
    public Propietario getPropietario() {
        return this.propietario;
    }
    
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getImporte() {
        return this.importe;
    }
    
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public Set getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set citas) {
        this.citas = citas;
    }




}


