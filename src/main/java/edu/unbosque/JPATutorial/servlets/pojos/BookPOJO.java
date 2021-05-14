package edu.unbosque.JPATutorial.servlets.pojos;

public class BookPOJO {

    private Integer bookId;

    private String title;

    private String isbnId;

    private Integer authorId;

    private String genre;

    public BookPOJO() {
    }

    public BookPOJO(Integer bookId, String title, String isbnId, Integer authorId, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.isbnId = isbnId;
        this.authorId = authorId;
        this.genre = genre;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbnId() {
        return isbnId;
    }

    public void setIsbnId(String isbnId) {
        this.isbnId = isbnId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
