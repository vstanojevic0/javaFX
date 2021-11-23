package org.example;
import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "address")
    private String Address;

    @Column(name = "speedmbs")
    private String speedMBs;
    @Column(name = "bandwidth")
    private String bandwidth;
    @Column(name = "duration")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Address='" + Address + '\'' +
                ", speedMBs='" + speedMBs + '\'' +
                ", bandwidth='" + bandwidth + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    public Customer(int id, String firstName, String lastName, String address, String  speedMBs, String bandwidth, String duration) {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        Address = address;
        this.speedMBs = speedMBs;
        this.bandwidth = bandwidth;
        this.duration = duration;
    }
    public Customer( String firstName, String lastName, String address, String  speedMBs, String bandwidth, String duration) {
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

    public Customer(){

    }


    public Customer(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
    }

    String  string = "Vrsta podataka tekstualnih";


}
