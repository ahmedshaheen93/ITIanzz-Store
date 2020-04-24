package eg.gov.iti.jets.controller.product;

import com.google.gson.Gson;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.dto.ProductDto;
import eg.gov.iti.jets.model.dto.ProductSearchExampleDTO;
import eg.gov.iti.jets.service.ProductService;
import eg.gov.iti.jets.utilty.ProductMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "searchForProduct", urlPatterns = "/searchForProduct")
public class SearchForProductController extends HttpServlet {

    private static final long serialVersionUID = -8115366100166977771L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null && !message.isEmpty()) {

            ProductSearchExampleDTO
                    productSearchExampleDTO = new Gson().fromJson(message, ProductSearchExampleDTO.class);
            ProductService productService = (ProductService) getServletContext().getAttribute("productService");
            List<Product> products = productService.searchByProductDTO(productSearchExampleDTO);
            List<ProductDto> productDtos = new ArrayList<>();
            for (Product product : products) {
                ProductDto productDto = ProductMapper.mapToProductDto(product);
                productDtos.add(productDto);
            }


            String json = new Gson().toJson(productDtos);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().println(json);
        }

    }
}
