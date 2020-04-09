package eg.gov.iti.jets.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SCRATCH_CARDS")
public class ScratchCard implements Serializable {

    private static final long serialVersionUID = -3693279181871996359L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SCRATCH_CARD_ID", nullable = false)
    private Long scratchCardId;

    @Column(name = "CARD_AMOUNT", nullable = false)
    private double cardAmount;

    @Column(name = "CARD_NUMBER", nullable = false)
    private String cardNumber;

    @Column(name = "VALID", nullable = false)
    private boolean valid;

    public ScratchCard() {
    }

    public ScratchCard(double cardAmount, String cardNumber, boolean valid) {
        this.cardAmount = cardAmount;
        this.cardNumber = cardNumber;
        this.valid = valid;
    }

    public Long getScratchCardId() {
        return scratchCardId;
    }

    public void setScratchCardId(Long scratchCardId) {
        this.scratchCardId = scratchCardId;
    }

    public double getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(double cardAmount) {
        this.cardAmount = cardAmount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
