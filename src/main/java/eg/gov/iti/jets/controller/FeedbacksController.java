package eg.gov.iti.jets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "feedbacks", urlPatterns = "/feedbacks")
public class FeedbacksController extends HttpServlet {

    private static final long serialVersionUID = -3037046973099934324L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("feedbacks.jsp").include(req, resp);
    }

}
