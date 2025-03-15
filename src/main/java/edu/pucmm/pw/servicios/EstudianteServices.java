package edu.pucmm.pw.servicios;

import edu.pucmm.pw.entidades.Estudiante;
import edu.pucmm.pw.util.NoExisteEstudianteException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EstudianteServices {

    private static EstudianteServices instancia;

    private EstudianteServices() {
    }

    public static EstudianteServices getInstancia() {
        if(instancia == null) {
            instancia = new EstudianteServices();
        }
        return instancia;
    }

    public List<Estudiante> listarEstudiante() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Estudiante", Estudiante.class).list();
        }
    }

    public Estudiante getEstudiantePorMatricula(int matricula) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Estudiante.class, matricula);
        }
    }

    public Estudiante crearEstudiante(Estudiante estudiante) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(estudiante);
            transaction.commit();
            return estudiante;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(estudiante);
            transaction.commit();
            return estudiante;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new NoExisteEstudianteException("No existe el estudiante: " + estudiante.getMatricula());
        }
    }

    public boolean eliminandoEstudiante(int matricula) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Estudiante estudiante = session.get(Estudiante.class, matricula);
            if (estudiante != null) {
                session.remove(estudiante);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
