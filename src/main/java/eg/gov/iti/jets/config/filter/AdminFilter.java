package eg.gov.iti.jets.config.filter;

import eg.gov.iti.jets.model.Role;
import eg.gov.iti.jets.model.dto.UserDto;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/scratchCardRequest", "/customers",
        "/make-as-admin", "/newCategory", "/addProduct", "/update-product", "/userInfo"})
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        UserDto user = (UserDto) httpRequest.getSession().getAttribute("user");
        if (user != null && user.getRole() == Role.ADMIN_ROLE) {
            filterChain.doFilter(request, response);
        } else {
            request.setAttribute("errorMessage", "you dont have authority to view this page , please login as admin");
            ((HttpServletResponse) response).sendRedirect("login?authorize=false");
        }
    }

}
