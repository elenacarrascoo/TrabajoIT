/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.HibernateUtil;
import modelo.Paciente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ecarr
 */
public class pacienteDAO {
    Session session = null;
    
    public void altaPaciente(Paciente p){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        tx.commit();
    }
    
    public void bajaPaciente(Paciente p){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
    }
    
    public void actualizarPaciente(Paciente p){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(p);
        tx.commit();
    }
    
    public Paciente obtenerPaciente(int idPaciente){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Propietario where id = " + idPaciente);
        Paciente p = (Paciente) q.uniqueResult();
        tx.commit();
        return p;
    }
    
    //obetenerPaciente(idPropietario)
    //obtenerNumHistorial(id_paciente)
}
