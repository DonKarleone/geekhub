package com.geekhub.hw10.task2.servlet;

import com.geekhub.hw10.task2.service.FeedbackService;
import com.geekhub.hw10.task2.model.Feedback;
import com.geekhub.hw10.task2.model.Page;
import com.geekhub.hw10.task2.model.PageRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    private static final int PAGE_SIZE = 5;
    private FeedbackService feedbackService = new FeedbackService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("userName");
        req.setAttribute("name", name);
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPerPage(PAGE_SIZE);
        if (req.getParameter("page") != null) {
            pageRequest.setPage(Integer.parseInt(req.getParameter("page")));
        } else {
            pageRequest.setPage(1);
        }
        Page<Feedback> feedbackPage = feedbackService.getFeedbacks(pageRequest);
        req.setAttribute("feedbackPage", feedbackPage);
        req.setAttribute("totalPages", feedbackPage.getTotalCountOfPages());
        req.setAttribute("currentPage", feedbackPage.getPage());
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
