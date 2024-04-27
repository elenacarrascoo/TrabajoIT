/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author clarabecerragil
 */

import modelo.HibernateUtil;
import modelo.Historial;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class historialDAO {
    Session session = null;
    
    public void altaHistorial(Historial h){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(h);
        tx.commit();
    }
    
    public void bajaHistorial(Historial h){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(h);
        tx.commit();
    }
    
    public void actualizarHistorial(Historial h){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(h);
        tx.commit();
    }
    
    public Historial obtenerHistorialPaciente(int idPaciente){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Historial where idPaciente = " + idPaciente);
        Historial h = (Historial) q.uniqueResult();
        tx.commit();
        return h;
    }
}
