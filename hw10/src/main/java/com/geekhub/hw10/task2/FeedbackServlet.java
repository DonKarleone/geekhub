package com.geekhub.hw10.task2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    private FeedbackService feedbackService = new FeedbackService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("userName");
        req.setAttribute("name", name);
        List<Feedback> feedbacks = feedbackService.getFeedbacks();
        req.setAttribute("feedbackList", feedbacks);
        req.getRequestDispatcher("/WEB-INF/servlet.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("submit") != null) {
            HttpSession session = req.getSession();
            Feedback feedback = new Feedback();
            feedback.setName((String) session.getAttribute("userName"));
            feedback.setText(req.getParameter("text"));
            feedback.setRank(Integer.valueOf(req.getParameter("rank")));
            feedback.setDate(LocalDateTime.now());
            feedbackService.createFeedback(feedback);
            resp.sendRedirect("/feedback");
        } else if (req.getParameter("logout") != null) {
            HttpSession session = req.getSession();
            session.invalidate();
            resp.sendRedirect("/login");
        }
    }
}
