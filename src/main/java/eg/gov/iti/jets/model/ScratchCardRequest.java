package eg.gov.iti.jets.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SCRATCH_CARD_REQUESTS")
@NamedQueries({@NamedQuery(name = "ScratchCardRequest.getApprovedRequests"
        , query = "SELECT  scr from ScratchCardRequest scr where scr.approved =:approved"),
        @NamedQuery(name = "ScratchCardRequest.getApprovedRequestsByUser"
                , query = "SELECT  scr from ScratchCardRequest scr where  scr.user =:user AND scr.approved =:approved")})

public class ScratchCardRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SCRATCH_CARD_REQUEST_ID")
    private Long scratchCardRequestId;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "SCRATCH_CARD_ID")
    private ScratchCard scratchCard;

    @Column(name = "APPROVED", nullable = false)
    private boolean approved;

    @Column(name = "SCRATCH_CARD_REQUEST_TIME")
    private LocalDateTime requestDateAndTime;

    @Column(name = "SCRATCH_CARD_APPROVED_TIME")
    private LocalDateTime approvedDateAndTime;

    public ScratchCardRequest() {
    }

    public Long getScratchCardRequestId() {
        return scratchCardRequestId;
    }

    public void setScratchCardRequestId(Long scratchCardRequestId) {
        this.scratchCardRequestId = scratchCardRequestId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ScratchCard getScratchCard() {
        return scratchCard;
    }

    public void setScratchCard(ScratchCard scratchCard) {
        this.scratchCard = scratchCard;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getRequestDateAndTime() {
        return requestDateAndTime;
    }

    public void setRequestDateAndTime(LocalDateTime requestDateAndTime) {
        this.requestDateAndTime = requestDateAndTime;
    }

    public LocalDateTime getApprovedDateAndTime() {
        return approvedDateAndTime;
    }

    public void setApprovedDateAndTime(LocalDateTime approvedDateAndTime) {
        this.approvedDateAndTime = approvedDateAndTime;
    }
}

