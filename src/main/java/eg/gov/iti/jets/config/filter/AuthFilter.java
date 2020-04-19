/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.gov.iti.jets.config.filter;

import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.service.UserService;
import eg.gov.iti.jets.utilty.ReadWriteCookei;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lts
 */
@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final List<String> PUBLIC_MACHES = Arrays.asList("/login", "/index", "/home", "/products",
            "/about", "/registration", "/fonts", "/images", "/include", "/scripts", "/style");
    FilterConfig filterConfig = null;

    /**
     * @param request  The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain    The filter chain we are processing
     * @throws IOException      if an input/output error occurs
     * @throws ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        User user = (User) httpRequest.getSession().getAttribute("user");

        Optional<String> userCookie = ReadWriteCookei.readCookie("email", httpRequest);

        if (user != null || checkPublic(httpRequest)) {
            System.out.println("on chain.doFilter");
            chain.doFilter(request, response);
        } else if (userCookie.isPresent() && !userCookie.get().trim().isEmpty()) {
            performUserCookie(userCookie.get(), request, response, chain);

        } else {
            System.out.println("httpRequest.getRequestURI()" + httpRequest.getRequestURI());
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
        System.out.println(this.getClass().getName() + " destroy called ");
    }

    /**
     * Init method for this filter
     */
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        System.out.println(this.getClass().getName() + " init called ");

    }

    private boolean checkPublic(HttpServletRequest httpRequest) {
        boolean startsWith = false;
        String path = httpRequest.getRequestURI();
        for (String publicPath : PUBLIC_MACHES) {
            if (path.startsWith(httpRequest.getContextPath() + publicPath)) {
                startsWith = true;
            }
        }
        return startsWith;
    }

    private void performUserCookie(String cookie, ServletRequest request, ServletResponse response,
                                   FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            UserService userService = (UserService) httpServletRequest.getServletContext().getAttribute("userService");
            User user = userService.findByEmail(cookie);

            if (user != null) {
                httpServletRequest.getSession().setAttribute("user", user);
                chain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
}
