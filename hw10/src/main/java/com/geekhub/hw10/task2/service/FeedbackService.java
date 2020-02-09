package com.geekhub.hw10.task2.service;

import com.geekhub.hw10.task2.model.Feedback;
import com.geekhub.hw10.task2.model.Page;
import com.geekhub.hw10.task2.model.PageRequest;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class FeedbackService {

    List<Feedback> feedbacks = new CopyOnWriteArrayList<>();

    public FeedbackService() {
        fillFeedbackList();
    }

    public void createFeedback(Feedback feedback) {
        feedbacks.add(feedback);
    }

    public Page<Feedback> getFeedbacks(PageRequest pageRequest) {
        Page<Feedback> feedbackPage = new Page<>();
        feedbackPage.setPageSize(pageRequest.getPerPage());
        feedbackPage.setPage(pageRequest.getPage());
        feedbackPage.setTotalCountOfPages(
                (int) (Math.ceil((double) feedbacks.size() /
                        (double) pageRequest.getPerPage()))
        );
        feedbackPage.setItems(feedbacks.stream()
                .sorted(Comparator.comparing(Feedback::getDate).reversed())
                .skip((pageRequest.getPage() - 1) * pageRequest.getPerPage())
                .limit(pageRequest.getPerPage())
                .collect(Collectors.toList()));
        return feedbackPage;
    }

    public void fillFeedbackList() {
        for (int i = 1; i < 40; i++) {
            Feedback feedback = new Feedback();
            feedback.setName("user1");
            feedback.setText("Comment" + i);
            feedback.setRank(4);
            feedback.setDate(LocalDateTime.now());
            createFeedback(feedback);
        }
    }
}