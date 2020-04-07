/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.gov.iti.jets.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

/**
 * @author lts
 */
public class ConnectionToDB {

    private static ConnectionToDB instance;
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    private ConnectionToDB() {
        System.out.println("hi");
        entityManagerFactory = Persistence.createEntityManagerFactory("iti.store");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public static void close() {
        if (entityManager.isOpen() && instance != null) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static synchronized ConnectionToDB getInstance() {
        if (instance == null) {
            instance = new ConnectionToDB();
        }
        return instance;
    }
}
