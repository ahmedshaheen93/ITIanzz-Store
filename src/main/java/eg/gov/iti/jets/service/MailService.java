package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.ScratchCard;
import eg.gov.iti.jets.model.User;

public interface MailService {

    boolean sendScratchCardMail(User user, ScratchCard scratchCard);

    boolean sendForgetPasswordMail(User user, String randomPassword);
}
