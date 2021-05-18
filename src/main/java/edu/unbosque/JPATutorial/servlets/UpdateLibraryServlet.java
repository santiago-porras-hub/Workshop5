package edu.unbosque.JPATutorial.servlets;


import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.LibraryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateLibraryServlet", value = "/update-library")
public class UpdateLibraryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer libraryId = Integer.parseInt(request.getParameter("libraryId"));

        String name = request.getParameter("name");


        LibraryService libraryService = new LibraryService();
        libraryService.modifyLibrary(libraryId, name);

        response.sendRedirect("./index.jsp");
    }


}
