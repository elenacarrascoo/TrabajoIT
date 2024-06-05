package persistencia;

/**
 *
 * @author clarabecerragil
 */

import java.util.List;
import modelo.Cita;
import modelo.HibernateUtil;
import modelo.Historial;
import modelo.Paciente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class historialDAO {
    Session session = null;

    public historialDAO() {
    }
    
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
    
    public List<Historial> obtenerHistorialPaciente(Paciente paciente){
        List<Historial> listadoHistorial = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Historial where idPaciente =:idPaciente");
        q.setParameter("idPaciente", paciente.getId());
        listadoHistorial = (List<Historial>) q.list();
        tx.commit();
        return listadoHistorial;
    }
    
    public Paciente obtenerPacienteIdCita(Cita cita){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Historial where idCita =:idCita");
        q.setParameter("idCita", cita.getId());
        Historial h = (Historial) q.uniqueResult();
        tx.commit();
        return h.getPaciente();
    }
    
    public Historial obtenerHistorial(int numHistorial){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Historial where num_historial = " + numHistorial);
        Historial h = (Historial) q.uniqueResult();
        tx.commit();
        return h;
    }
    
}
