package crudapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectSession {
    private static SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    private static ConnectSession session;

    private ConnectSession(){}

    public static ConnectSession getConnectSession(){
        if(session == null){
            session = new ConnectSession();
        }
        return session;
    }

    public SessionFactory getSession(){
        return sessionFactory;
    }



}
