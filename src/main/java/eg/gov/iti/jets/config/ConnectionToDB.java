package eg.gov.iti.jets.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class ConnectionToDB {
    private static ConnectionToDB instance;
    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    private ConnectionToDB() {
        entityManagerFactory = Persistence.createEntityManagerFactory("iti.store");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static synchronized ConnectionToDB getInstance() {
        return instance = Objects.requireNonNullElseGet(instance, ConnectionToDB::new);
    }

    public static void close() {
        if (entityManager.isOpen() && instance != null) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
