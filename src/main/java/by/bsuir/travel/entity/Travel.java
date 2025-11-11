package by.bsuir.travel.entity;

import java.util.Objects;

/**
 * Entity класс для представления туриста/клиента туристического агентства
 */
public class Travel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String destination;
    private Integer durationDays;
    private Double price;

    public Travel() {
    }

    public Travel(Integer id, String firstName, String lastName, String email,
                  String phoneNumber, String destination, Integer durationDays, Double price) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.destination = destination;
        this.durationDays = durationDays;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        return Objects.equals(id, travel.id) &&
               Objects.equals(firstName, travel.firstName) &&
               Objects.equals(lastName, travel.lastName) &&
               Objects.equals(email, travel.email) &&
               Objects.equals(phoneNumber, travel.phoneNumber) &&
               Objects.equals(destination, travel.destination) &&
               Objects.equals(durationDays, travel.durationDays) &&
               Objects.equals(price, travel.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phoneNumber,
                          destination, durationDays, price);
    }

    @Override
    public String toString() {
        return "Travel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", destination='" + destination + '\'' +
                ", durationDays=" + durationDays +
                ", price=" + price +
                '}';
    }
}
