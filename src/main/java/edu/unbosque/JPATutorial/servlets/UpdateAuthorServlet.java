package edu.unbosque.JPATutorial.servlets;

import edu.unbosque.JPATutorial.services.AuthorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateAuthorServlet", value = "/update-author")
public class UpdateAuthorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer authorId = Integer.parseInt(request.getParameter("authorId"));

        String name = request.getParameter("name");
        String country = request.getParameter("country");

        AuthorService authorService = new AuthorService();
        authorService.modifyAuthor(authorId,name,country);

        response.sendRedirect("./index.jsp");
    }



}
