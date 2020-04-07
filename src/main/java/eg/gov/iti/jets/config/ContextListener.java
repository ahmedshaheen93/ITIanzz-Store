package eg.gov.iti.jets.config;

import eg.gov.iti.jets.repository.impl.UserRepositoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Logger;

public class ContextListener implements ServletContextListener {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * injecting service impl on context when the app started
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        // context.setAttribute("userService", new UserRepositoryImpl());
        // context.setAttribute("storeService", new StoreServiceImpl());
        // context.setAttribute("productService", new ProductServiceImpl());
        // context.setAttribute("orderService", new OrderServiceImpl());
        // context.setAttribute("categoryService", new CategoryServiceImpl());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("######### contextDestroyed #########");
        ConnectionToDB.close();

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                logger.info(String.format("deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
                logger.info(String.format("Error deregistering driver %s", driver) + e);
            }
        }
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            logger.info(String.format("Error Thread sleep %s", e));
        }

    }
}
