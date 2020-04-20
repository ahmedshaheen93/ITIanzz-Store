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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lts
 */
@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

    private static final List<String> PUBLIC_MACHES = Arrays.asList(
            "/login", "/index", "/home", "/products", "/cart", "/view-product",
            "/about", "/registration", "/feedback", "/fonts",
            "/images", "/include", "/scripts", "/style");

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
            goLogin(response);
        }
    }

    private boolean checkPublic(HttpServletRequest httpRequest) {
        boolean startsWith = false;
        String path = httpRequest.getRequestURI();
        System.out.println(path);
        System.out.println(httpRequest.getContextPath());
        if (path.equals(httpRequest.getContextPath() + "/")) {
            startsWith = true;
        } else {
            for (String publicPath : PUBLIC_MACHES) {
                if (path.startsWith(httpRequest.getContextPath() + publicPath)) {
                    startsWith = true;
                }
            }
        }
        return startsWith;
    }

    private void performUserCookie(String cookie, ServletRequest request, ServletResponse response,
                                   FilterChain chain) throws IOException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            UserService userService = (UserService) httpServletRequest.getServletContext().getAttribute("userService");
            User user = userService.findByEmail(cookie);

            if (user != null) {
                httpServletRequest.getSession().setAttribute("user", user);
                chain.doFilter(request, response);
            } else {
                goLogin(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            goLogin(response);
        }
    }

    private void goLogin(ServletResponse response) throws IOException {
        ((HttpServletResponse) response).sendRedirect("login");
    }
}
