package edu.unbosque.JPATutorial.servlets.pojos;

public class RentPOJO {

    private Integer rentId;



    private String rentingDate;


    public  RentPOJO(){

    }

    public RentPOJO(Integer rentId, String rentingDate) {
        this.rentId = rentId;
        this.rentingDate = rentingDate;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public String getRentingDate() {
        return rentingDate;
    }

    public void setRentingDate(String rentingDate) {
        this.rentingDate = rentingDate;
    }
}
