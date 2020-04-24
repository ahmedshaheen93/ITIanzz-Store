package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.ScratchCard;
import eg.gov.iti.jets.model.dto.UserDto;

public interface MailService {

    boolean sendScratchCardMail(UserDto user, ScratchCard scratchCard);

    boolean sendForgetPasswordMail(UserDto user, String randomPassword);
}
