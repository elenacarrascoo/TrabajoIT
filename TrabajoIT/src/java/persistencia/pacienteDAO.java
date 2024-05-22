/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Paciente;
import modelo.Propietario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ecarr
 */
public class pacienteDAO {
    Session session = null;
    
    public pacienteDAO(){
        
    }
    
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
        Query q = session.createQuery("From Paciente where id = " + idPaciente);
        Paciente p = (Paciente) q.uniqueResult();
        tx.commit();
        return p;
    }
    
    public List<Paciente> obtenerPacientes(Propietario propietario){
        List<Paciente> listadoCompleto = null;
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Paciente where dniPropietario =:dniPropietario");
        q.setParameter("dniPropietario", propietario.getDni());
        listadoCompleto = (List<Paciente>) q.list();
        tx.commit();
        return listadoCompleto;
    }

/*
    public Paciente obtenerPacienteNumHistorial(int numHistorialCita) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("From Paciente where numHistorial = " + numHistorialCita);
        Paciente p = (Paciente) q.uniqueResult();
        tx.commit();
        return p;
    }*/
}
