/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
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
        Query q = session.createQuery("FROM Paciente where id = " + idPaciente);
        Paciente p = (Paciente) q.uniqueResult();
        tx.commit();
        return p;
    }
    
    public List<Paciente> obtenerPacientes(String dniPropietario){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Paciente where dniPropietario = " + dniPropietario);
        List<Paciente> pacientes = (List<Paciente>) q.list();
        tx.commit();
        return pacientes;
    }

    //obtenerNumHistorial(id_paciente)

    public Paciente obtenerPacienteNumHistorial(int numHistorialCita) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Paciente where numHistorial = " + numHistorialCita);
        Paciente p = (Paciente) q.uniqueResult();
        tx.commit();
        return p;
    }
}
