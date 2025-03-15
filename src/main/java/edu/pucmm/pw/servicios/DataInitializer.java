package edu.pucmm.pw.servicios;

import edu.pucmm.pw.entidades.Estudiante;
import org.hibernate.Session;

public class DataInitializer {
    
    public static void initData() {
        // Crear algunos estudiantes de prueba
        if (EstudianteServices.getInstancia().listarEstudiante().isEmpty()) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                session.beginTransaction();
                
                session.persist(new Estudiante(20011136, "Carlos Camacho", "ITT"));
                session.persist(new Estudiante(20011137, "Carmen Santana", "ISC"));
                session.persist(new Estudiante(20011138, "Juan Perez", "ISC"));
                
                session.getTransaction().commit();
            }
        }
    }
}