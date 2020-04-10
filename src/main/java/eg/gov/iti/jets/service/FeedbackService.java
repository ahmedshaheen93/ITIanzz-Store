package eg.gov.iti.jets.service;

import eg.gov.iti.jets.model.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedbacks();
    void createFeedback(Feedback feedback);
}
