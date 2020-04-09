package eg.gov.iti.jets.config;

import eg.gov.iti.jets.service.impl.OrderServiceImpl;
import eg.gov.iti.jets.service.impl.ProductServiceImpl;
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
        context.setAttribute("userService", UserServiceImpl.getInstance());
//        context.setAttribute("storeService", StoreServiceImpl);
        context.setAttribute("productService", ProductServiceImpl.getInstance());
        context.setAttribute("orderService", OrderServiceImpl.getInstance());
//        context.setAttribute("categoryService", CategoryServiceImpl);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("######### contextDestroyed #########");
        ConnectionToDB.close();
    }
}
