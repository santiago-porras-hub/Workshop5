package edu.unbosque.JPATutorial.servlets.pojos;

import edu.unbosque.JPATutorial.jpa.entities.Book;

import java.util.Date;

public class EditionPOJO {

    private Integer editionId;

    private String description;

    private String releaseYear;

    private Integer bookId;

    public EditionPOJO() {
    }

    public EditionPOJO(Integer editionId, String description, String releaseYear, Integer bookId) {
        this.editionId = editionId;
        this.description = description;
        this.releaseYear = releaseYear;
        this.bookId = bookId;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
