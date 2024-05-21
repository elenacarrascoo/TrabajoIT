package modelo;
// Generated 21-may-2024 21:28:50 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Historial generated by hbm2java
 */
public class Historial  implements java.io.Serializable {


     private Integer numHistorial;
     private Paciente paciente;
     private Set citas = new HashSet(0);
     private Set pacientes = new HashSet(0);

    public Historial() {
    }

	
    public Historial(Paciente paciente) {
        this.paciente = paciente;
    }
    public Historial(Paciente paciente, Set citas, Set pacientes) {
       this.paciente = paciente;
       this.citas = citas;
       this.pacientes = pacientes;
    }
   
    public Integer getNumHistorial() {
        return this.numHistorial;
    }
    
    public void setNumHistorial(Integer numHistorial) {
        this.numHistorial = numHistorial;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Set getCitas() {
        return this.citas;
    }
    
    public void setCitas(Set citas) {
        this.citas = citas;
    }
    public Set getPacientes() {
        return this.pacientes;
    }
    
    public void setPacientes(Set pacientes) {
        this.pacientes = pacientes;
    }




}


