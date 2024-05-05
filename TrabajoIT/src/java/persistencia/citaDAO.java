/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author clarabecerragil
 */
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import modelo.Cita;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class citaDAO {
    
    Session session = null;
    
    public void altaCita(Cita c){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
    }
    
    public void bajaCita(Cita c){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
    }
    
    public void actualizarCita(Cita c){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
    }
    
    public Cita obtenerCita(int idCita){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Cita where id = " + idCita);
        Cita c = (Cita) q.uniqueResult();
        tx.commit();
        return c;
    }
    
    public List<Cita> obtenerCitasVeterinario(int idVeterinario){
        List<Cita> citas;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Cita where idVeterinario = " + idVeterinario);
        citas = (List<Cita>) q.list();
        tx.commit();
        return citas;
    }
    
    public List<Cita> obtenerCitasPaciente(int numHistorial){
        List<Cita> citas;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Cita where numHistorial = " + numHistorial);
        citas = (List<Cita>) q.list();
        tx.commit();
        return citas;
    }
    
    public List<Cita> obtenerCitasPendientes(int numHistorial, Date fecha, Date hora){
        List<Cita> citas;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Cita WHERE numHistorial = :numHistorial AND fecha > :fecha AND hora > :hora");
        q.setParameter("numHistorial", numHistorial);
        q.setParameter("fecha", fecha);
        q.setParameter("hora", hora);
        citas = (List<Cita>) q.list();
        tx.commit();
        return citas;
    } 
}
