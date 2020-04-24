package eg.gov.iti.jets.controller.scratchcard;

import eg.gov.iti.jets.model.ScratchCard;
import eg.gov.iti.jets.model.ScratchCardRequest;
import eg.gov.iti.jets.model.dto.UserDto;
import eg.gov.iti.jets.service.MailService;
import eg.gov.iti.jets.service.ScratchCardRequestService;
import eg.gov.iti.jets.service.ScratchCardService;
import eg.gov.iti.jets.utilty.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


// create filter for this servelt => only admin users can access
@WebServlet(name = "scratchCardRequest", urlPatterns = "/scratchCardRequest")
public class ScratchCardRequestController extends HttpServlet {

    private static final long serialVersionUID = 7365147479343973508L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScratchCardRequestService scratchCardRequestService = (ScratchCardRequestService) req.getServletContext().getAttribute("scratchCardRequestService");
        List<ScratchCardRequest> approvedRequests = scratchCardRequestService.getApprovedRequests(false);
        req.setAttribute("approvedRequests", approvedRequests);
        req.getRequestDispatcher("scratch-card-request.jsp").include(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestId = req.getParameter("requestId");
        String operation = req.getParameter("operation");
        if (requestId != null && operation != null) {
            ScratchCardRequestService scratchCardRequestService =
                    (ScratchCardRequestService) req.getServletContext().getAttribute("scratchCardRequestService");
            Long id = Long.parseLong(requestId);

            MailService mailService = (MailService) req.getServletContext().getAttribute("mailService");
            ScratchCardService scratchCardService =
                    (ScratchCardService) req.getServletContext().getAttribute("scratchCardService");
            boolean done = false;
            ScratchCardRequest scratchCardRequest = scratchCardRequestService.findById(id);
            if (scratchCardRequest != null) {
                switch (operation) {
                    case "approve":
                        scratchCardRequest = createRequest(scratchCardRequest, scratchCardService);
                        scratchCardRequest = scratchCardRequestService.updateScratchCardRequest(scratchCardRequest);
                        UserDto userDto = UserMapper.mapUser(scratchCardRequest.getUser());
                        done = mailService.sendScratchCardMail(userDto, scratchCardRequest.getScratchCard());
                        break;
                    case "delete":
                        done = scratchCardRequestService.deleteScratchCardRequest(scratchCardRequest);
                        break;
                }
                resp.getWriter().write("{'done':" + done + "}");
            }

        }
    }

    private ScratchCardRequest createRequest(ScratchCardRequest scratchCardRequest,
                                             ScratchCardService scratchCardService) {
        ScratchCard card = scratchCardService.create(scratchCardRequest.getAmount());
        scratchCardRequest.setApproved(true);
        scratchCardRequest.setApprovedDateAndTime(LocalDateTime.now());
        scratchCardRequest.setScratchCard(card);
        return scratchCardRequest;
    }

}
