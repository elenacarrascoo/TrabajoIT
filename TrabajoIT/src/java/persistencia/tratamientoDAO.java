/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.*;
import modelo.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Usuario
 */
public class tratamientoDAO {
    
    Session session = null;

    public tratamientoDAO() {
    }

    public void crearTratamiento(Tratamiento tratamiento) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(tratamiento);
        tx.commit();
    }

    public Tratamiento obtenerTratamiento(int idTratamiento) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Tratamiento where id=:idTratamiento");
        q.setParameter("idTratamiento", idTratamiento);
        Tratamiento tratamiento = (Tratamiento)q.uniqueResult();
        tx.commit();
        return tratamiento;
    }

    public List<Tratamiento> obtenerTodosLosTratamientos() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Tratamiento");
        List<Tratamiento> listaTratamientos = q.list();
        tx.commit();
        return listaTratamientos;
    }

    public void actualizarTratamiento(Tratamiento tratamiento) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(tratamiento);
        tx.commit();
    }

    public void eliminarTratamiento(Tratamiento tratamiento) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(tratamiento);
        tx.commit();
    }
}

    


