package eg.gov.iti.jets.controller.scratchcard;

import eg.gov.iti.jets.exception.UserBalanceViolation;
import eg.gov.iti.jets.model.ScratchCard;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.service.ScratchCardRequestService;
import eg.gov.iti.jets.service.ScratchCardService;
import eg.gov.iti.jets.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "scratchCard", urlPatterns = "/scratchCard")
public class ScratchCardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        User user = (User) req.getSession().getAttribute("user");
        if (number != null) {
            ScratchCardService scratchCardService = (ScratchCardService) req.getServletContext().getAttribute("ValidateScratchCard");
            UserService userService = (UserService) req.getServletContext().getAttribute("userService");
            // validate
            ScratchCard card = scratchCardService.checkScratchCardWithNumber(number);
            if (card != null && user != null) {
                // update
                try {
                    userService.addUserBalance(user, card.getCardAmount());
                    card.setValid(false);
                    scratchCardService.updateScratchCard(card);
                    //balance updated
                    System.out.println("balance updated");


                } catch (UserBalanceViolation userBalanceViolation) {
                    userBalanceViolation.printStackTrace();
                }
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
        String balance = req.getParameter("balance");
        User user = (User) req.getSession().getAttribute("user");
        if (balance != null && user != null) {
            ScratchCardRequestService scratchCardRequestService = (ScratchCardRequestService) req.getServletContext().getAttribute("scratchCardRequestService");
            Boolean requestBalance = scratchCardRequestService.requestBalance(user, Double.parseDouble(balance.trim()));
            if (requestBalance) {
                // balance requested
                System.out.println("balance requested");

            }
        }
    }
}
