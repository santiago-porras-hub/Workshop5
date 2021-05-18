package edu.unbosque.JPATutorial.servlets;


import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateCustomerServlet", value = "/update-customer")
public class UpdateCustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String genre = request.getParameter("genre");
        Integer age = Integer.parseInt(request.getParameter("age"));

        CustomerService customerService = new CustomerService();
        customerService.modifyCustomer(email,first_name,last_name,genre,age);

        response.sendRedirect("./index.jsp");
    }

}
