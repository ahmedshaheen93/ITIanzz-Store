package eg.gov.iti.jets.service.impl;

import eg.gov.iti.jets.model.Feedback;
import eg.gov.iti.jets.repository.FeedbackRepository;
import eg.gov.iti.jets.repository.impl.FeedbackRepositoryImpl;
import eg.gov.iti.jets.service.FeedbackService;

import java.util.List;
import java.util.Objects;

public class FeedbackServiceImpl implements FeedbackService {

    private static FeedbackServiceImpl instance;

    FeedbackRepository feedbackRepository;

    protected FeedbackServiceImpl() {
        this.feedbackRepository = FeedbackRepositoryImpl.getInstance();
    }

    public static synchronized FeedbackServiceImpl getInstance() {
        instance = Objects.requireNonNullElseGet(instance, FeedbackServiceImpl::new);
        return instance;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public void createFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

}
