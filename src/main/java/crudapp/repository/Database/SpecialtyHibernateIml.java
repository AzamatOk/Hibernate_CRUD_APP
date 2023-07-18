package crudapp.repository.Database;

import crudapp.util.ConnectSession;
import crudapp.model.Specialty;
import crudapp.model.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import crudapp.repository.SpecialtyRepository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyHibernateIml implements SpecialtyRepository {
    SessionFactory sessionFactory;

    @Override
    public Specialty getById(Integer integer) {
        Specialty specialty = null;
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            specialty = (Specialty) session.load(Specialty.class, integer);
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        }finally {
            return specialty;
        }
    }



    @Override
    public List<Specialty> getAll() {
        List<Specialty> specialties = new ArrayList();
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            specialties = session.createQuery("From Specialty").list();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return specialties;
        }
    }

    @Override
    public Specialty save(Specialty specialty) {
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            session.beginTransaction();
            session.save(specialty);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return specialty;
        }
    }

    @Override
    public Specialty update(Specialty specialty) {
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            session.beginTransaction();
            session.update(specialty);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return specialty;
        }
    }

    @Override
    public void deleteById(Integer integer) {
        Specialty specialty;
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            specialty =(Specialty) session.get(Specialty.class, integer);
            session.beginTransaction();
            specialty.setStatus(Status.DELETED);
            session.update(specialty);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
