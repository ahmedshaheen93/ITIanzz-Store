package eg.gov.iti.jets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "store", urlPatterns = "/store")
public class StoreController extends HttpServlet {

    private static final long serialVersionUID = 3867803697941680936L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("store.jsp").include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("description"));
        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("phone"));
        System.out.println(req.getParameter("fax"));
        
        System.out.println(req.getParameter("country"));
        System.out.println(req.getParameter("state"));
        System.out.println(req.getParameter("city"));
        System.out.println(req.getParameter("street"));
        System.out.println(req.getParameter("zipcode"));
        
        System.out.println(req.getParameter("facebook"));
        System.out.println(req.getParameter("twitter"));
        System.out.println(req.getParameter("youtube"));
        System.out.println(req.getParameter("linkedin"));
        System.out.println(req.getParameter("instagram"));
        
        // super.doPost(req, resp);
    }
}
