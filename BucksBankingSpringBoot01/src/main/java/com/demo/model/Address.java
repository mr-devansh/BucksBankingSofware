package com.demo.model;

import jakarta.persistence.*;
@Entity
@Table(name="address_tb")
public class Address {
    // Attributes
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String city;
    private String country;

    // Constructor
    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public Address() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // toString method
    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
