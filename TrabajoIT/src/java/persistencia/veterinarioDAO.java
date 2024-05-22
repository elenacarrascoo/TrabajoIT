/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.*;
import modelo.Cita;
import modelo.HibernateUtil;
import modelo.Veterinario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ecarr
 */
public class veterinarioDAO {

    Session session = null;
    
    public veterinarioDAO(){
        
    }

    public Veterinario loginVeterinario(String dni, String password) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Veterinario where dni='" + dni + "' and password='" + password + "'");
        Veterinario v = (Veterinario) q.uniqueResult();
        tx.commit();
        return v;

    }

    public List<Cita> obtenerCitas(String dni) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Cita where dniVeterinario='" + dni + "'");
        List citasVeterinario = (List<Cita>) q.list();
        tx.commit();
        return citasVeterinario;

    }

    public void altaVeterinario(Veterinario v) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(v);
        tx.commit();
    }

  public void eliminarVeterinario(Veterinario veterinario) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.delete(veterinario);
        tx.commit();
    }

    public void modificarVeterinario(Veterinario veterinario) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.update(veterinario);
        tx.commit();
    }
    
    public List<Veterinario> obtenerCompañeros() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Veterinario");
        List <Veterinario> listaVeterinarios = (List<Veterinario>) q.list();
        tx.commit();
        return listaVeterinarios;

    }
    
    public Veterinario obtenerVeterinarioBaja(String dni, String password){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Veterinario where dni='" + dni + "' and password='" + password + "'");
        Veterinario veterinario = (Veterinario)q.uniqueResult();
        tx.commit();
        return veterinario;
        
    }
    
    public Veterinario obtenerVeterinario(String dni){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Veterinario where dni='" + dni + "'");
        Veterinario veterinario = (Veterinario)q.uniqueResult();
        tx.commit();
        return veterinario;
        
    }
     

}

