package com.geekhub.hw10.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class FeedbackService {

    private List<Feedback> feedbacks = new ArrayList<>();

    void createFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }

    List<Feedback> getFeedbacks() {
        return feedbacks.stream()
                .sorted(Comparator.comparing(Feedback::getDate).reversed())
                .collect(Collectors.toList());
    }

}