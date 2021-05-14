package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createCustomerServlet", value = "/create-customer")
public class CreateCustomerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String genre = request.getParameter("genre");
        String age = request.getParameter("age");
        int ageCast = Integer.parseInt(age);

        CustomerService customerService = new CustomerService();
        customerService.saveCustomer(email, first, last, genre, ageCast);


        response.sendRedirect("./index.jsp");
    }
}
