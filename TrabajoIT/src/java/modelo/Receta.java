package modelo;
// Generated 21-may-2024 21:28:50 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Receta generated by hbm2java
 */
public class Receta  implements java.io.Serializable {


     private Integer id;
     private Cita cita;
     private String dosis;
     private String indicaciones;
     private Set citas = new HashSet(0);

    public Receta() {
    }

	
    public Receta(Cita cita, String dosis, String indicaciones) {
        this.cita = cita;
        this.dosis = dosis;
        this.indicaciones = indicaciones;
    }
    public Receta(Cita cita, String dosis, String indicaciones, Set citas) {
       this.cita = cita;
       this.dosis = dosis;
       this.indicaciones = indicaciones;
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
    public String getDosis() {
        return this.dosis;
    }
    
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    public String getIndicaciones() {
        return this.indicaciones;
    }
    
    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }
    public Set getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set citas) {
        this.citas = citas;
    }




}


