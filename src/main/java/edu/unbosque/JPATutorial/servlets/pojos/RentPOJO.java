package edu.unbosque.JPATutorial.servlets.pojos;

public class RentPOJO {

    private Integer rentId;

    private String email;

    private String rentingDate;


    public  RentPOJO(){

    }
    public RentPOJO(Integer rentId, String email, String rentingDate) {
        this.rentId = rentId;
        this.email = email;
        this.rentingDate = rentingDate;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(String rentingDate) {
        this.rentingDate = rentingDate;
    }
}
