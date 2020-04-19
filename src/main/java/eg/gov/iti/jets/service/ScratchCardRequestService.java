package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.ScratchCardRequest;
import eg.gov.iti.jets.model.User;

import java.util.List;

public interface ScratchCardRequestService {

    /**
     * user request balance from admin
     * add to request balance table
     *
     * @param user   who request for balance
     * @param amount of money requested
     * @return if mail send or not
     */
    Boolean requestBalance(User user, Double amount);

    List<ScratchCardRequest> getApprovedRequests(Boolean approved);

    List<ScratchCardRequest> getApprovedRequestsByUser(User user, Boolean approved);

    /**
     * when admin approved that card can be used and send card number to user
     * when user use card number => add balance => set card as used , card is not valid
     *
     * @param scratchCardRequest
     * @return
     */

    ScratchCardRequest updateScratchCardRequest(ScratchCardRequest scratchCardRequest);

    ScratchCardRequest findById(Long id);

}
