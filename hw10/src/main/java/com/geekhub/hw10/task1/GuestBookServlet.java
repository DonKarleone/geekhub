package com.geekhub.hw10.task1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GuestBookServlet extends javax.servlet.http.HttpServlet {

    public static List guestbook = new ArrayList<Feedback>();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HtmlForm.printHeader(out);
        HtmlForm.printForm(out);
        HtmlForm.printMessages(out);
        HtmlForm.printFooter(out);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HtmlForm.handleForm(req, res);
        doGet(req, res);
    }
}
