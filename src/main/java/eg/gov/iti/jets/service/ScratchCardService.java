package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.ScratchCard;

public interface ScratchCardService {
    ScratchCard checkScratchCardWithNumber(String cardNumber);

    ScratchCard updateScratchCard(ScratchCard scratchCard);


}
