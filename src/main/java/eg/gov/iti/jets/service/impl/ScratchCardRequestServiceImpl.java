package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.model.ScratchCardRequest;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.repository.ScratchCardRequestRepository;
import eg.gov.iti.jets.repository.impl.ScratchCardRequestRepositoryImpl;
import eg.gov.iti.jets.service.ScratchCardRequestService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ScratchCardRequestServiceImpl implements ScratchCardRequestService {
    ScratchCardRequestRepository scratchCardRequestRepository = ScratchCardRequestRepositoryImpl.getInstance();
    private static ScratchCardRequestServiceImpl instance;

    protected ScratchCardRequestServiceImpl() {
    }

    @Override
    public List<ScratchCardRequest> getApprovedRequests(Boolean approved) {
        return scratchCardRequestRepository.getApprovedRequests(approved);
    }

    @Override
    public List<ScratchCardRequest> getApprovedRequestsByUser(User user, Boolean approved) {
        return scratchCardRequestRepository.getApprovedRequestsByUser(user, approved);
    }


    // enter card number
    public ScratchCardRequest updateScratchCardRequest(ScratchCardRequest scratchCardRequest) {
        return scratchCardRequestRepository.update(scratchCardRequest);
    }

    @Override
    public ScratchCardRequest findById(Long id) {
        return scratchCardRequestRepository.findById(id);
    }

    @Override
    public boolean deleteScratchCardRequest(ScratchCardRequest scratchCardRequest) {
        scratchCardRequestRepository.delete(scratchCardRequest);
        return true;
    }

    @Override
    public Boolean requestBalance(User user, Double amount) {
        // request card
        ScratchCardRequest scratchCardRequest = new ScratchCardRequest();
        scratchCardRequest.setUser(user);
        scratchCardRequest.setApproved(false);
        scratchCardRequest.setAmount(amount);
        scratchCardRequest.setRequestDateAndTime(LocalDateTime.now());
        ScratchCardRequest save = scratchCardRequestRepository.save(scratchCardRequest);
        if (save.getScratchCardRequestId() > 0) {
            return true;
        }
        return false;
    }

    public static synchronized ScratchCardRequestServiceImpl getInstance() {
        return instance = Objects.requireNonNullElseGet(instance, ScratchCardRequestServiceImpl::new);
    }
}
