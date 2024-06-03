/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import modelo.*;
import org.apache.struts2.ServletActionContext;
import persistencia.citaDAO;
import persistencia.medicamentoDAO;
import persistencia.veterinarioDAO;

/**
 *
 * @author Usuario
 */
public class veterinarioAction extends ActionSupport {

    public veterinarioAction() {
    }

    private String boton;
    private String dni;
    private String nombre;
    private String especialidad;
    private int experiencia;
    private int telefono;
    private String correo;
    private String password;
    private List<Cita> citasVeterinario;
    private List<Veterinario> listaVeterinarios;
    private String dniVeterinario;
    private String idCita;
    private Medicamento medicamentos;

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

       
    public String getIdVeterinario() {
        return dniVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.dniVeterinario = idVeterinario;
    }

    public List<Veterinario> getListaVeterinarios() {
        return listaVeterinarios;
    }

    public void setListaVeterinarios(List<Veterinario> listaVeterinarios) {
        this.listaVeterinarios = listaVeterinarios;
    }

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Cita> getCitasVeterinario() {
        return citasVeterinario;
    }

    public void setCitasVeterinario(List<Cita> citasVeterinario) {
        this.citasVeterinario = citasVeterinario;
    }

    public Medicamento getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamento medicamentos) {
        this.medicamentos = medicamentos;
    }
    

    public String execute() throws Exception {
        System.out.println("Valor de boton: " + boton); // Para depuración
        veterinarioDAO dao = new veterinarioDAO();
        
        HttpServletRequest request = ServletActionContext.getRequest();
        idCita = request.getParameter("idCita");
        
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("idCita",idCita);
        
        switch (boton) {
            case "Modificar Datos":
                return "modificarDatos";

            case "Consultar Compañeros":
                listaVeterinarios = dao.obtenerCompañeros();
                return "consultarCompañeros";

            case "Baja Veterinario":
                return "bajaVeterinario";

            case "registro":
                Veterinario veterinario = new Veterinario(dni, nombre, especialidad, experiencia, telefono, correo, password);
                dao.altaVeterinario(veterinario);
                listaVeterinarios = dao.obtenerCompañeros();
                return "nuevoRegistro";

            case "Modificacion":
                veterinario = (Veterinario) session.get("veterinario");
                if (veterinario != null) {
                    veterinario = (Veterinario) session.get("veterinario");
                    veterinario.setEspecialidad(this.getEspecialidad());
                    veterinario.setExperiencia(this.getExperiencia());
                    veterinario.setTelefono(this.getTelefono());
                    veterinario.setCorreo(this.getCorreo());
                    veterinario.setPassword(this.getPassword());
                    dao.modificarVeterinario(veterinario);

                    return "modificacionVeterinario";
                }

            case "LogOut":
                return "salir";

            case "Volver":
                return "volver";

            case "Gestión Recetas":
                return "gestionRecetas";

            case "Generar Factura":
                return "generarFactura";

            case "Ver Paciente":
                return "verPaciente";

            case "Alta Tratamiento":
                return "altaTratamiento";

            case "Alta Receta":
                return "altaReceta";

            case "Alta Medicamento":
                return "altaMedicamento";
                
            case "Actualizar Medicamento":
                return "actualizarMedicamento";

            case "Gestión Medicamentos":
                citaDAO cdao = new citaDAO();
                Cita c = cdao.obtenerCita(Integer.parseInt(idCita));
                Medicamento m = c.getMedicamento();
                this.setMedicamentos(m);
                return "gestionMedicamentos";

            case "Cancelar":
                return "cancelar";

            case "Dar de Baja":
                veterinario = dao.obtenerVeterinarioBaja(dni, password);
                dao.eliminarVeterinario(veterinario);
                listaVeterinarios = dao.obtenerCompañeros();
                return "eliminar";

            default:

                return SUCCESS;

        }
    }
    
     public String consultarAgenda() {
         
        veterinarioDAO dao = new veterinarioDAO();
        Map<String, Object> session = ActionContext.getContext().getSession();

        // Depuración: Imprime el tipo del objeto en la sesión
        Object sessionVeterinario = session.get("veterinario");
        if (sessionVeterinario == null) {
            System.out.println("El objeto 'veterinario' en la sesión es null");
            throw new ClassCastException("El objeto en la sesión es null");
        } else {
            System.out.println("El tipo del objeto en la sesión es: " + sessionVeterinario.getClass().getName());
        }

        // Asegúrate de que el objeto en la sesión es del tipo Veterinario
        if (sessionVeterinario instanceof Veterinario) {
            Veterinario v = (Veterinario) sessionVeterinario;
            citasVeterinario = dao.obtenerCitas(v.getDni());
            return "consultarAgenda";
        } else {
            throw new ClassCastException("El objeto en la sesión no es del tipo Veterinario");
        }
    }

    public String consultarAgenda(){
        veterinarioDAO dao = new veterinarioDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        idCita = request.getParameter("idCita");
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("idCita",idCita);
        Veterinario v = (Veterinario) session.get("veterinario");
        citasVeterinario = dao.obtenerCitas(v.getDni());
        return "consultarAgenda";
    }
    
    public void validate() {
        String actionName = ActionContext.getContext().getName();

        if (actionName.equals("registrarProfesional")) {
            // Validar DNI
            String patronDNI = "^[0-9]{7,8}[A-Za-z]$";
            Pattern patron1 = Pattern.compile(patronDNI);
            Matcher macheadorDNI = patron1.matcher(this.getDni());

            if (this.getDni().isEmpty()) {
                addFieldError("dni", "Introduce el DNI");
            } else if (!macheadorDNI.matches()) {
                addFieldError("dni", "Formato de DNI incorrecto");
            }

            // Validar nombre
            String patronNombre = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$"; // Expresión regular para letras (mayúsculas, minúsculas) y espacios

            if (this.getNombre().isEmpty()) {
                addFieldError("nombre", "Introduce el nombre");
            } else {
                // Verificar que el nombre solo contenga letras y espacios
                Pattern pattern = Pattern.compile(patronNombre);
                Matcher matcher = pattern.matcher(this.getNombre());

                if (!matcher.matches()) {
                    addFieldError("nombre", "El nombre solo puede contener letras y espacios");
                }
            }

            // Validar especialidad
            if (this.getEspecialidad().isEmpty()) {
                addFieldError("especialidad", "Introduce la especialidad");
            }

            // Validar experiencia (debe ser un número positivo y no superar los 50 años)
            if (this.getExperiencia() < 0) {
                addFieldError("experiencia", "La experiencia debe ser un número positivo");
            } else if (this.getExperiencia() > 50) {
                addFieldError("experiencia", "La experiencia no puede superar los 50 años");
            }

            // Validar correo electrónico
            // Expresión regular para validar un correo electrónico con dominio 'upovet.es'
            String patronCorreo = "^[\\w.-]+@upovet\\.es$";
            Pattern patronCorreoPattern = Pattern.compile(patronCorreo);
            Matcher macheadorCorreo = patronCorreoPattern.matcher(this.getCorreo());

            // Verificar que el campo de correo no esté vacío
            if (this.getCorreo().isEmpty()) {
                addFieldError("correo", "Introduce el correo electrónico");
            } // Verificar que el correo coincida con el patrón esperado
            else if (!macheadorCorreo.matches()) {
                addFieldError("correo", "Formato de correo electrónico incorrecto. Debe ser nombre@upovet.es");
            }

            // Validar teléfono
            String patronTelefono = "^[0-9]{9}$";
            Pattern patronTelefonoPattern = Pattern.compile(patronTelefono);
            Matcher macheadorTelefono = patronTelefonoPattern.matcher(String.valueOf(this.getTelefono()));

            if (this.getTelefono() <= 0) {
                addFieldError("telefono", "Introduce un teléfono válido");
            } else if (!macheadorTelefono.matches()) {
                addFieldError("telefono", "El teléfono debe tener 9 dígitos");
            }

            // Validar contraseña
            if (this.getPassword().isEmpty()) {
                addFieldError("password", "Introduce la contraseña");
            } else if (this.getPassword().length() < 8 || this.getPassword().length() > 11) {
                addFieldError("password", "La contraseña debe tener entre 8 y 11 caracteres");
            }
        }
    }

}
