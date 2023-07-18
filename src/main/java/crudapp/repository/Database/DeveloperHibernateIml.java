package crudapp.repository.Database;

import crudapp.model.Developer;
import crudapp.model.Status;
import crudapp.repository.DeveloperRepository;
import crudapp.util.ConnectSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class DeveloperHibernateIml implements DeveloperRepository {
    private static SessionFactory sessionFactory;

    @Override
    public Developer getById(Integer integer) {
        Developer developer = null;
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            developer = (Developer) session.load(Developer.class, integer);
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        }finally {
            return developer;
        }
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> developers = new ArrayList();
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            developers = session.createQuery( "FROM Developer",
                    Developer.class
            ).getResultList();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return developers;
        }
    }

    @Override
    public Developer save(Developer developer) {
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            session.beginTransaction();
            session.save(developer);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return developer;
        }
    }

    @Override
    public Developer update(Developer developer) {
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            session.beginTransaction();
            session.update(developer);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            return developer;
        }
    }

    @Override
    public void deleteById(Integer integer) {
        Developer developer;
        try (Session session = ConnectSession.getConnectSession().getSession().openSession();) {
            developer =(Developer) session.get(Developer.class, integer);
            session.beginTransaction();
            developer.setStatus(Status.DELETED);
            session.update(developer);
            session.getTransaction().commit();
            if (session != null && session.isOpen()) {
                session.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
