package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import modelo.Paciente;
import modelo.Propietario;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
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
    private File image;
    private String imageFileName;
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

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
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
    
    //Alta paciente
    public String execute() throws Exception {
        
        Map<String, Object> session = ActionContext.getContext().getSession();
        Propietario prop = (Propietario) session.get("propietario");
        pacienteDAO pdao = new pacienteDAO(); 
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd");
        Date fechaFormateada = formater.parse(this.getFechaNacimiento());
        //Creación nuevo paciente con todos sus atributos
        Paciente p = new Paciente(prop, this.getNombre(), this.getEspecie(), this.getRaza(), this.getSexo(), Integer.parseInt(this.getEdad()), fechaFormateada);
        
        //Cambiar nombre foto y asociarla al paciente creado anteriormente
        if (this.getImage() != null) {
            String filePath = ServletActionContext.getServletContext().getRealPath("/FOTOS");
            System.out.println(filePath);
            filePath = filePath.replace("\\build", "");
            System.out.println(filePath);
            String fileName = UUID.randomUUID().toString().replace("-", "") + imageFileName.substring(imageFileName.lastIndexOf("."));

            FileUtils.copyFile(this.getImage(), new File(filePath, fileName));

            p.setFoto("/FOTOS/" + fileName);
        }else{
            p.setFoto("/FOTOS/predeterminada.png");
        }
        
        //Dar de alta al paciente
        pdao.altaPaciente(p);
        return SUCCESS;
    }
    
    public String formModificarPaciente(){
        //Meter el paciente a modificar en la session
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
