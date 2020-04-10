package eg.gov.iti.jets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eg.gov.iti.jets.model.Feedback;
import eg.gov.iti.jets.service.FeedbackService;

import java.io.IOException;

@WebServlet(name = "feedback", urlPatterns = "/feedback")
public class FeedbackController extends HttpServlet {

    private static final long serialVersionUID = -3037046973099934324L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("feedback.jsp").include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        FeedbackService feedbackService = (FeedbackService) req.getServletContext().getAttribute("feedbackService");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String subject = req.getParameter("subject");
        String message = req.getParameter("message");
        feedbackService.createFeedback(new Feedback(name, email, subject, message));

        resp.sendRedirect("feedback.jsp?feedback=received");
    }
}
