package edu.unbosque.JPATutorial.servlets;


import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.RentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createRentServlet", value = "/create-rent")
public class CreateRentServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");
        String rentingDate = request.getParameter("rentingDate");

        RentService rentService = new RentService();
        rentService.saveRent(email,rentingDate);
        response.sendRedirect("./index.jsp");

    }
}
