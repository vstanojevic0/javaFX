package org.example;

public class Customer {

    private String firstName;
    private String lastName;
    private String Address;

    private String speedMBs;
    private String bandwidth;
    private String duration;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSpeedMBs() {
        return speedMBs;
    }

    public void setSpeedMBs(String speedMBs) {
        this.speedMBs = speedMBs;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Address='" + Address + '\'' +
                ", speedMBs=" + speedMBs +
                ", bandwidth=" + bandwidth +
                ", duration=" + duration +
                '}';
    }

    public Customer(String firstName, String lastName, String address, String  speedMBs, String bandwidth, String duration) {
        this.firstName = firstName;
        this.lastName = lastName;
        Address = address;
        this.speedMBs = speedMBs;
        this.bandwidth = bandwidth;
        this.duration = duration;
    }
    public Customer(String firstName, String lastName, String address , String speedMBs){
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = address;
        this.speedMBs = speedMBs;
    }
}
