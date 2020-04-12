package eg.gov.iti.jets.config;

import eg.gov.iti.jets.model.Store;
import eg.gov.iti.jets.service.impl.*;

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
        context.setAttribute("storeService", StoreServiceImpl.getInstance());
        context.setAttribute("userService", UserServiceImpl.getInstance());
        context.setAttribute("productService", ProductServiceImpl.getInstance());
        context.setAttribute("orderService", OrderServiceImpl.getInstance());
        context.setAttribute("categoryService", CategoryServiceImpl.getInstance());
        context.setAttribute("feedbackService", FeedbackServiceImpl.getInstance());
        context.setAttribute("imageService", ImageServiceImpl.getInstance());
        Store storeInfo = StoreServiceImpl.getInstance().getStoreInfo();
        System.out.println(storeInfo);
        context.setAttribute("storeInstance", storeInfo);
        UserServiceImpl.getInstance().checkAdminExistence();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("######### contextDestroyed #########");
        ConnectionToDB.close();
    }
}
