package com.geekhub.hw10;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ListIterator;

import static com.geekhub.hw10.FeedbackServlet.*;

public class HtmlForm {

    public static void printHeader(PrintWriter out) {
        out.println("<HTML><HEAD><TITLE>Guestbook</TITLE></HEAD>");
        out.println("<BODY>");
    }

    public static void printForm(PrintWriter out) {
        out.println("<form action=\"/feedback\" method=\"post\">");
        out.println("Name: <input name=\"name\"/>");
        out.println("<br><br>");
        out.println("Text: <textarea name=\"text\"/></textarea>");
        out.println("<br><br>");
        out.println("Rank: <select name=\"rank\">");
        out.println("<option>1</option>");
        out.println("<option>2</option>");
        out.println("<option>3</option>");
        out.println("<option>4</option>");
        out.println("<option>5</option>");
        out.println("</select>");
        out.println("<br><br>");
        out.println("<button type=\"submit\">Submit</button>");
        out.println("</form>");
    }

    public static void printMessages(PrintWriter out) {
        ListIterator li = guestbook.listIterator(guestbook.size());
        while (li.hasPrevious()) {
            Feedback feedback;
            feedback = (Feedback) li.previous();
            out.println("<DL>");
            out.println("<DT><B> Name : " + feedback.name + "</B>");
            out.println("<DT> Text : " + feedback.text);
            out.println("<DT> Rank : " + feedback.rank);
            out.println("<DT> Date : " + feedback.date);
            out.println("</DL>");
        }
    }

    public static void printFooter(PrintWriter out) {
        out.println("</BODY>");
    }

    public static void handleForm(HttpServletRequest req,
                                  HttpServletResponse res) {
        Feedback feedback = new Feedback();

        feedback.name = req.getParameter("name");
        feedback.text = req.getParameter("text");
        feedback.rank = Integer.valueOf(req.getParameter("rank"));
        feedback.date = LocalDateTime.now();
        guestbook.add(feedback);
    }
}