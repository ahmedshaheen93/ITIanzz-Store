package eg.gov.iti.jets.tlds;

import eg.gov.iti.jets.model.dto.ProductDto;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ProductTLD extends SimpleTagSupport {
    ProductDto product;

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    /*
        *<div class="mx-auto col-md-6 col-lg-4">
                            <div class="featured-container p-5">
                                <img src="../images/home/img-products/product-7.png" class="img-fluid" alt="product" />
                                <span class="featured-search-icon" data-toggle="modal" data-target="#productModal">
                                     <i class="fas fa-search"></i>
                                 </span>
                                    <a href="#" class="featured-store-link text-captilaze">add to cart</a>
                            </div>
                            <h6 class="text-capitalize text-center my-2">special product</h6>
                            <h6 class="text-center">
                                <span class="text-muted old-price mx-2">$200</span>
                                <span>$100</span>
                            </h6>
                        </div>
                        <!--
        * */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
//        product.getPrimaryImage().getImagePath()
        try {
            out.println("<div class=\"mx-auto col-md-6 col-lg-4\">");
            out.println("<div class=\"featured-container p-5\">");
            out.println("<img src=\"" + product.getPrimaryImage() + "\" class=\"img-fluid\" alt=\"product\" />");
            out.println("<span class=\"featured-search-icon\" data-toggle=\"modal\" data-target=\"#productModal\">");
            out.println("<i class=\"fas fa-search\"></i>");
            out.println("</span>");
            out.println("<a href=\"#\" class=\"featured-store-link text-captilaze addToCart \" id=\"" + product.getProductId() + "\">add to cart </a>");
            out.println("</div>");
            out.println("<h6 class=\"text-capitalize text-center my-2\">" + product.getProductName() + "</h6>");
            out.println("<h6 class=\"text-center\">");
            out.println("<span>$" + product.getPrice() + "</span>");
            out.println("</h6>");
            out.println("</div>");

        } catch (java.io.IOException ex) {
            throw new JspException("Error in NewTagHandler tag", ex);
        }
    }
}
