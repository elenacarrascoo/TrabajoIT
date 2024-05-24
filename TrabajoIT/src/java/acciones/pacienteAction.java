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
import java.util.Map;
import modelo.Paciente;
import modelo.Propietario;
import persistencia.citaDAO;
import persistencia.historialDAO;
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
    private String edad;
    private String fechaNacimiento;
    private int numHistorial;
    private int id;
    private int idCita;
    private int idPaciente;
    
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
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

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        Propietario prop = (Propietario) session.get("propietario");
        pacienteDAO pdao = new pacienteDAO(); 
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd");
        Date fechaFormateada = formater.parse(this.getFechaNacimiento());
        Paciente p = new Paciente(prop, this.getNombre(), this.getEspecie(), this.getRaza(), this.getSexo(), Integer.parseInt(this.getEdad()), fechaFormateada);
        pdao.altaPaciente(p);
        return SUCCESS;
    }
    
    public String formModificarPaciente(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        pacienteDAO pdao = new pacienteDAO();
        Paciente p = pdao.obtenerPaciente(this.getIdPaciente());
        session.put("pacienteModificar", p);
        return SUCCESS;
    }
    
    public String modificarPaciente() throws ParseException{
        Map<String, Object> session = ActionContext.getContext().getSession();
        pacienteDAO pdao = new pacienteDAO();
        Paciente p = (Paciente) session.get("pacienteAModificar");
        p.setNombre(this.getNombre());
        p.setEspecie(this.getEspecie());
        p.setRaza(this.getRaza());
        p.setSexo(this.getSexo());
        p.setEdad(Integer.parseInt(this.getEdad()));
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd");
        Date fechaFormateada = formater.parse(this.getFechaNacimiento());
        p.setFechaNacimiento(fechaFormateada);
        pdao.actualizarPaciente(p);
        return SUCCESS;
    }
    
    public String eliminarPaciente(){
        pacienteDAO pdao = new pacienteDAO();
        Paciente p = pdao.obtenerPaciente(this.getIdPaciente());
        pdao.bajaPaciente(p);
        return SUCCESS;
    }
    
    public String consultarPaciente(){
        historialDAO hdao = new historialDAO();
        citaDAO cdao = new citaDAO();
        Paciente p = hdao.obtenerPacienteIdCita(cdao.obtenerCita(this.getIdCita()));
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("paciente", p);
        return SUCCESS;
    }
    
    public void validate() {
        String actionName = ActionContext.getContext().getName();

        if (actionName.equals("registrarPaciente") || actionName.equals("actualizarPaciente")) {

            if (this.getNombre().equals("")) {
                addFieldError("nombre", "Introduce el nombre");
            }

            if (this.getSexo().equals("")) {
                addFieldError("sexo", "Introduce el sexo");
            } 

            if (Integer.parseInt(this.getEdad())==0) {
                addFieldError("edad", "Introduce la edad");
            }

            if (this.getFechaNacimiento().equals("")) {
                addFieldError("fechaNacimiento", "Introduce la fecha de nacimiento");
            }

        }
    }
    
}
