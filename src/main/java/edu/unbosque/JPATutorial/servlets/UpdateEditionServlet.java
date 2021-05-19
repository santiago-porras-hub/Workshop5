package edu.unbosque.JPATutorial.servlets;


import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateEditionServlet", value = "/update-edition")
public class UpdateEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer editionId = Integer.parseInt(request.getParameter("editionId"));

        String description = request.getParameter("description");
        String releaseYear = request.getParameter("releaseYear");


        EditionService editionService = new EditionService();
        editionService.modifyEdition(editionId, description, releaseYear);

        response.sendRedirect("./index.jsp");
    }
}
