package com.bucks.banking.model;

import jakarta.persistence.*;
@Entity
@Table(name="benefeciary_tb")

public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ssn;
    private String name;

    // Constructor
    public Beneficiary(String name) {
        this.name = name;
    }

    public Beneficiary() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString method
    @Override
    public String toString() {
        return "Beneficiary{" +
                "ssn=" + ssn +
                ", name='" + name + '\'' +
                '}';
    }
}
