package eg.gov.iti.jets.config;

import eg.gov.iti.jets.service.impl.CategoryServiceImpl;
import eg.gov.iti.jets.service.impl.OrderServiceImpl;
import eg.gov.iti.jets.service.impl.ProductServiceImpl;
import eg.gov.iti.jets.service.impl.StoreServiceImpl;
import eg.gov.iti.jets.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
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
        context.setAttribute("userService", new UserServiceImpl());
        context.setAttribute("storeService", new StoreServiceImpl());
        context.setAttribute("productService", new ProductServiceImpl());
        context.setAttribute("orderService", new OrderServiceImpl());
        context.setAttribute("categoryService", new CategoryServiceImpl());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("######### contextDestroyed #########");
        ConnectionToDB.close();
    }
}
