package modelo;
// Generated 21-may-2024 21:28:50 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tratamiento generated by hbm2java
 */
public class Tratamiento  implements java.io.Serializable {


     private Integer id;
     private Cita cita;
     private String tipo;
     private Date fecha;
     private double precio;
     private String resultados;
     private Set citas = new HashSet(0);

    public Tratamiento() {
    }

	
    public Tratamiento(Cita cita, String tipo, Date fecha, double precio, String resultados) {
        this.cita = cita;
        this.tipo = tipo;
        this.fecha = fecha;
        this.precio = precio;
        this.resultados = resultados;
    }
    public Tratamiento(Cita cita, String tipo, Date fecha, double precio, String resultados, Set citas) {
       this.cita = cita;
       this.tipo = tipo;
       this.fecha = fecha;
       this.precio = precio;
       this.resultados = resultados;
       this.citas = citas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Cita getCita() {
        return this.cita;
    }
    
    public void setCita(Cita cita) {
        this.cita = cita;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getResultados() {
        return this.resultados;
    }
    
    public void setResultados(String resultados) {
        this.resultados = resultados;
    }
    public Set getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set citas) {
        this.citas = citas;
    }




}


