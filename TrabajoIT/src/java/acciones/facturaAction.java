package acciones;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import java.util.Map;
import modelo.Factura;
import modelo.Propietario;
import persistencia.facturaDAO;

/**
 *
 * @author ecarr
 */
public class facturaAction extends ActionSupport {

    private Integer numFactura;
    private Propietario propietario;
    private Date fecha;
    private double importe;
    private List<Factura> facturas;

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

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public String execute() throws Exception {
        facturaDAO fdao = new facturaDAO();
        Factura factura = fdao.obtenerFactura(this.getNumFactura());
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("factura", factura);
        return SUCCESS;
    }

    public String actualizarFactura() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        Factura f = (Factura) session.get("factura");
        
        f.setImporte(this.getImporte());
        facturaDAO fdao = new facturaDAO();
        fdao.actualizarFactura(f);
        session.remove("factura");
        
        return SUCCESS;
    }
    
    public String eliminarFactura() {
        facturaDAO f = new facturaDAO();
        Factura facturaEliminar = f.obtenerFactura(this.getNumFactura());
        if(facturaEliminar != null){
            f.bajaFactura(facturaEliminar);
        }else{
            return "Error al coger la factura";
        }
        
        return SUCCESS;
    }
    
    public String verFacturas(){
       Map<String, Object> session = ActionContext.getContext().getSession();
       Propietario p = (Propietario) session.get("propietario");
       facturaDAO fdao = new facturaDAO();
       List<Factura> listaFacturas = fdao.obtenerFacturasPropietario(p);
       this.setFacturas(listaFacturas);
       return SUCCESS;
    }
    
    public String consultaFacturas(){
       Map<String, Object> session = ActionContext.getContext().getSession();
       facturaDAO fdao = new facturaDAO();
       List<Factura> listaFacturas = fdao.obtenerFacturas();
       this.setFacturas(listaFacturas);
       return SUCCESS;
    }
    
    /*
    public String consultarFactura(){
        facturaDAO fdao = new facturaDAO();
        Factura f = fdao.obtenerFactura(this.getNumFactura());
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("factura", f);
        return SUCCESS;
    }
    */  
    
   
}
