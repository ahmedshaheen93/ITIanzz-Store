package eg.gov.iti.jets.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FEEDBACKS")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 3449591563510024252L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FEEDBACK_ID")
    private Long feedbackId;

    @Column(name = "SENDER_NAME")
    private String senderName;

    @Column(name = "SENDER_EMAIL")
    private String senderEmail;

    @Column(name = "FEEDBACK_SUBJECT")
    private String subject;

    @Column(name = "FEEDBACK_MESSAGE")
    private String message;

    public Feedback() {
    }

    public Feedback(String senderName, String senderEmail, String subject, String message) {
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.subject = subject;
        this.message = message;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

}