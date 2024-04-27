/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.HibernateUtil;
import modelo.Propietario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ecarr
 */
public class propietarioDAO {
    Session session = null;
    
    public void altaPropietario(Propietario p){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
    }
    
    public void bajaPropietario(Propietario p){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
    }
    
    public void actualizarPropietario(Propietario p){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
    }
    
    public Propietario obtenerPropietario(int dniPropietario){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Propietario where dni = " + dniPropietario);
        Propietario p = (Propietario) q.uniqueResult();
        tx.commit();
        return p;
    }
    
    public Propietario loginPropietario(String nombre, String dni){
        session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        Query q=session.createQuery("From Propietario where nombre='"+nombre+"' and dni='"+dni+"'");
        Propietario p = (Propietario)q.uniqueResult();
        tx.commit();
        return p;
    }

}
