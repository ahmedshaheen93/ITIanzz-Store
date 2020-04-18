package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.model.ScratchCard;
import eg.gov.iti.jets.repository.ScratchCardRepository;
import eg.gov.iti.jets.repository.impl.ScratchCardRepositoryImpl;
import eg.gov.iti.jets.service.ScratchCardService;

public class ScratchCardServiceImpl implements ScratchCardService {
    ScratchCardRepository scratchCardRepository = ScratchCardRepositoryImpl.getInstance();

    @Override
    public ScratchCard checkScratchCardWithNumber(String cardNumber) {
        ScratchCard card = scratchCardRepository.findByNumberAndValid(cardNumber, true);
        return card;
    }

    @Override
    public ScratchCard updateScratchCard(ScratchCard scratchCard) {
        return scratchCardRepository.update(scratchCard);
    }

}
