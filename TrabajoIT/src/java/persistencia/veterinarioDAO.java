/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

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
    
    public Veterinario loginVeterinario(String nombre, String dni){
        session=HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx=session.beginTransaction();
        Query q=session.createQuery("From Veterinario where nombre='"+nombre+"' and dni='"+dni+"'");
        Veterinario v = (Veterinario)q.uniqueResult();
        tx.commit();
        return v;
    }
}