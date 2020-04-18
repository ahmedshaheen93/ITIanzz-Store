package eg.gov.iti.jets.repository;

import eg.gov.iti.jets.model.ScratchCardRequest;
import eg.gov.iti.jets.model.User;

import java.util.List;

public interface ScratchCardRequestRepository extends Crud<ScratchCardRequest, Long> {
    public List<ScratchCardRequest> getApprovedRequests(Boolean approved);

    public List<ScratchCardRequest> getApprovedRequestsByUser(User user, Boolean approved);
}
