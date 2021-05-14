package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "createEditionServlet", value = "/create-edition")
public class CreateEditionServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {

        response.setContentType("text/html");

        String description = request.getParameter("description");
        String releaseYear = request.getParameter("releaseyear");
        Date releaseYearCast =new SimpleDateFormat("dd/MM/yyyy").parse(releaseYear);

        EditionService editionService = new EditionService();
        editionService.saveEdition(description,releaseYearCast);

        response.sendRedirect("./index.jsp");
    }
}
