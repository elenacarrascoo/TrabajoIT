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
import modelo.Historial;
import modelo.Medicamento;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class citaDAO {
    
    Session session = null;

    public citaDAO() {
    }
    
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
    
    public List<Cita> obtenerCitasVeterinario(int dniVeterinario){
        List<Cita> citas;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Cita where dniVeterinario = " + dniVeterinario);
        citas = (List<Cita>) q.list();
        tx.commit();
        return citas;
    }
    
    public boolean comprobarCitaPendiente(Cita cita, Date fecha, Date hora){
        boolean encontrado = false;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Cita WHERE idCita = :idCita (fecha > :fecha OR (fecha = :fecha AND hora > :hora))");
        q.setParameter("idCita", cita.getId());
        q.setParameter("fecha", fecha);
        q.setParameter("hora", hora);
        
        if(q.uniqueResult()!=null){
            encontrado = true;
        }
        tx.commit();
        return encontrado;
    } 

    public List<Cita> obtenerCitaPendiente(Date fecha, Date hora){
        List<Cita> citasPendientes;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Cita WHERE fecha > :fecha OR (fecha = :fecha AND hora > :hora)");
        q.setParameter("fecha", fecha);
        q.setParameter("hora", hora);
        citasPendientes = (List<Cita>) q.list();
        tx.commit();
        return citasPendientes;
    } 
    
    public Medicamento obtenerMedicamentoCita(int idCita){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("SELECT idMedicamento FROM Cita where id = " + idCita);
        Medicamento m = (Medicamento) q.uniqueResult();
        tx.commit();
        return m;
    }
    /*
    public List<Cita> obtenerCitasHistorial(Historial historial){
        List<Cita> citas = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Cita where numHistorial =:numHistorial");
        q.setParameter("numHistorial", historial.getNumHistorial());
        citas = (List<Cita>) q.list();
        tx.commit();
        return citas;
    } 
*/
    
}
