package edu.unbosque.JPATutorial.servlets.pojos;

public class CustomerPOJO {

    private String email;

    private String fullName;

    private String genre;

    private Integer age;

    public CustomerPOJO() {
    }

    public CustomerPOJO(String email, String fullName, String genre, Integer age) {
        this.email = email;
        this.fullName = fullName;
        this.genre = genre;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
