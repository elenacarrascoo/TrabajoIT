package modelo;
// Generated 29-may-2024 18:20:30 by Hibernate Tools 4.3.1



/**
 * Historial generated by hbm2java
 */
public class Historial  implements java.io.Serializable {


     private Integer numHistorial;
     private Cita cita;
     private Paciente paciente;

    public Historial() {
    }

    public Historial(Cita cita, Paciente paciente) {
       this.cita = cita;
       this.paciente = paciente;
    }
   
    public Integer getNumHistorial() {
        return this.numHistorial;
    }
    
    public void setNumHistorial(Integer numHistorial) {
        this.numHistorial = numHistorial;
    }
    public Cita getCita() {
        return this.cita;
    }
    
    public void setCita(Cita cita) {
        this.cita = cita;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }




}


