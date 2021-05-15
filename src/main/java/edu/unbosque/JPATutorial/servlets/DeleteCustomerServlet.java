package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteCustomerServlet", value = "/delete-customer")
public class DeleteCustomerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");

        CustomerService customerService = new CustomerService();
        customerService.deleteCustomer(email);

        response.sendRedirect("./index.jsp");
    }
}
