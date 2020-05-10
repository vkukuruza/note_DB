package ua.lms.controllers;

import ua.lms.dao.entity.User;
import ua.lms.dao.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Start", urlPatterns = "/")
public class Start extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserRepository userRepository = new UserRepository();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        String html = "<html><body>";
        if (email != null && password != null) {
            User user = userRepository.getUserByEmailByPassword(email, password);
            if (user != null) {
                html += "Hello, " + user.getName() + "!<br/>" +
                        "<form method='get' action='/logout'>" +
                        "<input type='submit' value='Logout'>" +
                        "</form>";
                HttpSession session = request.getSession();
                session.setAttribute("name", user.getName());
            } else {
                html += "Your login was incorrect." +
                        "<form action='/login'>" +
                        "<input type='submit' value='Try again...'>" +
                        "</form>";
            }
            html += "</body></html>";
        }
        out.println(html);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String logout = request.getParameter("logout");
        String html = "<html><body>";
        if (session == null) {
            html += "<form method='post' name='login' action='/login'>" +
                    "Username: <input type='text' name='email'/> <br/>" +
                    "Password: <input type='password' name='password'/> <p/>" +
                    "<input type='submit' value='Login'>" +
                    "</form>" +
                    "<a href=/registration>Sign up...</a>" +
                    "</body></html>";
        } else {
            html += "Hello, " + session.getAttribute("name") + "!<br/>" +
                    "<form method='get' action='/logout'>" +
                    "<input type='submit' value='Logout'>" +
                    "</form>";
        }
        html += "</body></html>";
        out.println(html);
    }
}
