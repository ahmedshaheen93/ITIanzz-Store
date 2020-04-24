package eg.gov.iti.jets.controller.scratchcard;

import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.model.ScratchCard;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.model.dto.UserDto;
import eg.gov.iti.jets.service.ScratchCardRequestService;
import eg.gov.iti.jets.service.ScratchCardService;
import eg.gov.iti.jets.service.UserService;
import eg.gov.iti.jets.utilty.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "scratchCard", urlPatterns = "/scratchCard")
public class ScratchCardController extends HttpServlet {

    private static final long serialVersionUID = -7021389694221174888L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        System.out.println(number);
        UserDto userDto = (UserDto) req.getSession().getAttribute("user");
        if (number != null) {
            ScratchCardService scratchCardService = (ScratchCardService) req.getServletContext().getAttribute("scratchCardService");
            UserService userService = (UserService) req.getServletContext().getAttribute("userService");
            // validate
            ScratchCard card = scratchCardService.checkScratchCardWithNumber(number);
            if (card != null) {
                // update
                try {

                    Double userBalance = userService.addUserBalance(userDto, card.getCardAmount());
                    card.setValid(false);
                    scratchCardService.updateScratchCard(card);
                    //balance updated
                    System.out.println("balance updated");
                    userDto.setBalance(userBalance);
//                    req.getRequestDispatcher("/view-profile").forward(req, resp);
                    resp.sendRedirect("view-profile");
                } catch (UserBalanceViolation userBalanceViolation) {
                    userBalanceViolation.printStackTrace();
                }
            } else {
                resp.getWriter().write("not vaild card number");
            }
        }
    }

    /**
     * user request a card
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String balance = req.getParameter("amount");
        System.out.println("requested balance = " + balance);
        System.out.println(balance);
        UserDto userDto = (UserDto) req.getSession().getAttribute("user");
        if (balance != null && userDto != null) {
            ScratchCardRequestService scratchCardRequestService = (ScratchCardRequestService) req.getServletContext().getAttribute("scratchCardRequestService");
            User user = UserMapper.mapUser(userDto);
            Boolean requestBalance = scratchCardRequestService.requestBalance(user, Double.parseDouble(balance.trim()));
            if (requestBalance) {
                // balance requested
                System.out.println("balance requested");

            }
        }
    }
}
