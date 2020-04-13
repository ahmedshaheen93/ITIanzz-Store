package eg.gov.iti.jets.controller;

import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.Review;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.service.ProductService;
import eg.gov.iti.jets.service.ReviewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "reviewProduct" , urlPatterns = "/reviewProduct")
public class ReviewController extends HttpServlet {
    ReviewService reviewService;
    ProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        reviewService = ((ReviewService) getServletContext().getAttribute("reviewService"));
        String productId = req.getParameter("productId");
        Product product = new Product();
        product.setProductId(Long.parseLong(productId));
        /*String userId = req.getParameter("userId");
        User user = new User();
        user.setUserId(Long.parseLong(userId));*/
        List<Review> byProduct = reviewService.findByProduct(product);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");
        productService = (ProductService) getServletContext().getAttribute("productService");
        Product product = productService.findById(Long.parseLong(productId));
        User user = ((User) req.getSession().getAttribute("userId"));
        String reviewMessage = req.getParameter("reviewMessage");
        String reviewStars = req.getParameter("reviewStars");
        if (user != null){
            Review review = new Review(user , product , reviewMessage , LocalDateTime.now(), Integer.parseInt(reviewStars));
            review = reviewService.createReview(review);
            if (review.getReviewId() > 0){
               resp.setStatus(201);
            }else {
                resp.setStatus(403);
            }
        }else{
            resp.sendRedirect("/iti-store/login");
        }

    }
}
