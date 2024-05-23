/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Factura;
import modelo.HibernateUtil;
import modelo.Propietario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ecarr
 */
public class facturaDAO {
    Session session = null;

    public facturaDAO() {
    }
    
    public void altaFactura(Factura f){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(f);
        tx.commit();
    }
    
    public void bajaFactura(Factura f){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(f);
        tx.commit();
    }
    
    public void actualizarFactura(Factura f){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(f);
        tx.commit();
    }
    
    public Factura obtenerFactura(int numFactura){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Factura where numFactura = " + numFactura);
        Factura f = (Factura) q.uniqueResult();
        tx.commit();
        return f;
    }
    
    public List<Factura> obtenerFacturasPropietario(Propietario propietario){
        List<Factura> listadoCompleto = null;
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Factura where dniPropietario =:dniPropietario");
        q.setParameter("dniPropietario", propietario.getDni());
        listadoCompleto = (List<Factura>) q.list();
        tx.commit();
        return listadoCompleto;
    }
}
