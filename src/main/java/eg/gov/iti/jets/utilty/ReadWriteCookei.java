/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.gov.iti.jets.utilty;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author lts
 */
public class ReadWriteCookei {

    public static Optional<String> readCookie(String key, HttpServletRequest request) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(c -> key.equals(c.getName()))
                    .map(Cookie::getValue)
                    .findAny();
        }
        return Optional.empty();
    }

    public static void writeCookie(HttpServletResponse response,
                                   String key, String value, int maxAge) throws IOException {

        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
}
