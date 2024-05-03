/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import modelo.Paciente;
import modelo.Propietario;
import persistencia.pacienteDAO;

/**
 *
 * @author ecarr
 */
public class pacienteAction extends ActionSupport {
    
    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private int edad;
    private Date fechaNacimiento;
    private int numHistorial;
    private int id;
    private int numHistorialCita;
    
    public pacienteAction() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumHistorial() {
        return numHistorial;
    }

    public void setNumHistorial(int numHistorial) {
        this.numHistorial = numHistorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumHistorialCita() {
        return numHistorialCita;
    }

    public void setNumHistorialCita(int numHistorialCita) {
        this.numHistorialCita = numHistorialCita;
    }
    
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        Propietario prop = (Propietario) session.get("propietario");
        pacienteDAO pdao = new pacienteDAO();
        //VER COMO OBTENER NUM HISTORIAL
        Paciente p = new Paciente(this.getNombre(), this.getEspecie(), this.getRaza(), this.getSexo(), this.getEdad(), this.getFechaNacimiento(), prop.getDni(), this.getNumHistorial());
        pdao.altaPaciente(p);
        return SUCCESS;
    }
    
    public String modificarPaciente(){
        pacienteDAO pdao = new pacienteDAO();
        Paciente p = pdao.obtenerPaciente(id);
        p.setNombre(this.getNombre());
        p.setEspecie(this.getEspecie());
        p.setRaza(this.getRaza());
        p.setSexo(this.getSexo());
        p.setEdad(this.getEdad());
        p.setFechaNacimiento(this.getFechaNacimiento());
        return SUCCESS;
    }
    
    public String eliminarPaciente(){
        pacienteDAO pdao = new pacienteDAO();
        Paciente p = pdao.obtenerPaciente(id);
        pdao.bajaPaciente(p);
        return SUCCESS;
    }
    
    public String consultarPaciente(){
        pacienteDAO pdao = new pacienteDAO();
        Paciente p = pdao.obtenerPacienteNumHistorial(this.getNumHistorialCita());
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("paciente", p);
        return SUCCESS;
    }
    
}
