/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.HibernateUtil;
import modelo.Medicamento;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ecarr
 */
public class medicamentoDAO {

    Session session = null;

    public medicamentoDAO() {

    }

    public void altaMedicamento(Medicamento m) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(m);
        tx.commit();
    }

      public void eliminarMedicamento(Medicamento m){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(m);
        tx.commit();
    }   
    
    
    
  /*  public void eliminarMedicamento(Medicamento m) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(m);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }   */

    public void actualizarMedicamento(Medicamento m) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(m);
        tx.commit();
    }

    public List<Medicamento> obtenerMedicamentos() {
        List<Medicamento> listadoCompleto = null;
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("FROM Medicamento");
        listadoCompleto = (List<Medicamento>) q.list();
        tx.commit();
        return listadoCompleto;
    }

    public Medicamento obtenerMedicamento(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Medicamento m;
        Query q = session.createQuery("FROM Medicamento WHERE id =:" + id);
        m = (Medicamento) q.uniqueResult();
        return m;
    }

}
