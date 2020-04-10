package eg.gov.iti.jets.repository.impl;

import java.util.Objects;

import eg.gov.iti.jets.model.Feedback;
import eg.gov.iti.jets.repository.FeedbackRepository;

public class FeedbackRepositoryImpl extends CrudImpl<Feedback, Long> implements FeedbackRepository {
    private static FeedbackRepositoryImpl instance;

    private FeedbackRepositoryImpl() {
    }

    public static synchronized FeedbackRepositoryImpl getInstance() {
        instance = Objects.requireNonNullElseGet(instance, FeedbackRepositoryImpl::new);
        return instance;
    }
}