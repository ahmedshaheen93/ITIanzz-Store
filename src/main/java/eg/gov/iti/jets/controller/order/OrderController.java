package eg.gov.iti.jets.controller.order;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eg.gov.iti.jets.exception.ProductQuantityLimitExceeded;
import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.model.Order;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.Purchase;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.model.dto.ProductDto;
import eg.gov.iti.jets.model.dto.ResponeMessage;
import eg.gov.iti.jets.service.OrderService;
import eg.gov.iti.jets.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(name = "orders", urlPatterns = "/orders")
public class OrderController extends HttpServlet {

    private static final long serialVersionUID = -2688027528289014602L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            String productsPar = req.getParameter("products");
            if (productsPar != null) {
                Type listType = new TypeToken<ArrayList<ProductDto>>() {
                }.getType();
                List<ProductDto> productDtos = new Gson().fromJson(productsPar, listType);
                ProductService productService = (ProductService) getServletContext().getAttribute("productService");
                Set<Purchase> purchaseSet = new HashSet<>(0);
                for (ProductDto productDto : productDtos) {
                    Purchase purchase = new Purchase();
                    Product product = productService.findById(productDto.getProductId());
                    purchase.setProduct(product);
                    purchase.setQuantity(productDto.getQuantity());
                    purchase.setProductBuyPrice(product.getSellPrice());
                    purchaseSet.add(purchase);
                }
                OrderService orderService = (OrderService) getServletContext().getAttribute("orderService");

                try {
                    Order order = orderService.createOrder(user, purchaseSet);
                    if (order != null) {
                        PrintWriter writer = resp.getWriter();
                        resp.setStatus(201);
                        ResponeMessage responeMessage = new ResponeMessage("successfully ordered", 201);
//                        req.setAttribute("errorMessage", "successfully orderd");
//                        req.getRequestDispatcher("cart.jsp").include(req, resp);
                        String json = new Gson().toJson(responeMessage);
                        writer.write(json);
                    }

                } catch (UserBalanceViolation | ProductQuantityLimitExceeded ex) {
                    ex.printStackTrace();
                    PrintWriter writer = resp.getWriter();
                    resp.setStatus(460);
                    ResponeMessage responeMessage = new ResponeMessage(ex.getMessage(), 460);
//                        req.setAttribute("errorMessage", "successfully orderd");
//                        req.getRequestDispatcher("cart.jsp").include(req, resp);
                    String json = new Gson().toJson(responeMessage);
                    writer.write(json);
//                    req.setAttribute("errorMessage", ex.getMessage());
//                    req.getRequestDispatcher("cart.jsp").include(req, resp);
                }

            }
        } else {
            PrintWriter writer = resp.getWriter();
            ResponeMessage responeMessage = new ResponeMessage("/iti-store/login", 302);
            String json = new Gson().toJson(responeMessage);
            resp.setStatus(302);
            writer.write(json);
        }
    }
}
