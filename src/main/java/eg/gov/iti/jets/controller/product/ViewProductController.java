package eg.gov.iti.jets.controller.product;

import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.dto.ProductDto;
import eg.gov.iti.jets.service.ProductService;
import eg.gov.iti.jets.utilty.ProductMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "view-product", urlPatterns = {"/view-product"})
public class ViewProductController extends HttpServlet {

    private static final long serialVersionUID = -5076520322013207207L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            ProductService productService = (ProductService) getServletContext().getAttribute("productService");
            Product product = productService.findById(Long.parseLong(id));
            ProductDto productDto = ProductMapper.mapToProductDto(product);
            req.setAttribute("product", productDto);
            req.getRequestDispatcher("view-product.jsp").include(req, resp);
        }

    }
}
