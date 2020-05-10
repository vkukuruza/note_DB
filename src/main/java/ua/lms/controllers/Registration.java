package ua.lms.controllers;

import ua.lms.dao.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Registration", urlPatterns = "/registration")
public class Registration extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        String html = "<html><body>";
        if (session == null) {
            html += "<form method='post' name='registration' action='/registration'>" +
                    "Name: <input type='text' name='name'/> <br/>" +
                    "e-mail: <input type='text' name='email'/> <br/>" +
                    "Password: <input type='password' name='password'/> <p/>" +
                    "<input type='submit' value='Sign up'>" +
                    "</form>" +
                    "</body></html>";
        } else {
            response.sendRedirect("/login");
        }
        out.println(html);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserRepository userRepository = new UserRepository();
        HttpSession session = request.getSession(false);
        PrintWriter out = response.getWriter();
        String html = "<html><body>";
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (session == null) {
            if (!name.equals("") && !email.equals("") && !password.equals("")) {
                userRepository.newUser(name, email, password);
                response.sendRedirect("/login");
            } else {
                html += "All fields are required!<br/>" +
                        "<form method='get' action=/registration>" +
                        "<input type='submit' value='Try again'>" +
                        "</form>" +
                        "</body></html>";
            }
        } else {
            response.sendRedirect("/login");
        }
        out.println(html);

    }
}
