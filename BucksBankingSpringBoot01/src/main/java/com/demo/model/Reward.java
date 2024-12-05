package com.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="reward_tb")
public class Reward {
    // Attributes
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rewardConfirmationNumber;
    private int rewardAmount;
    private long accountNumber;

    // Constructor
    public Reward(int rewardAmount, long accountNumber) {
        this.rewardAmount = rewardAmount;
        this.accountNumber = accountNumber;
    }

    // Getters and Setters
    public long getRewardConfirmationNumber() {
        return rewardConfirmationNumber;
    }

    public void setRewardConfirmationNumber(long rewardConfirmationNumber) {
        this.rewardConfirmationNumber = rewardConfirmationNumber;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }

    public void setRewardAmount(int rewardAmount) {
        this.rewardAmount = rewardAmount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    // toString method
    @Override
    public String toString() {
        return "Reward{" +
                "rewardConfirmationNumber=" + rewardConfirmationNumber +
                ", rewardAmount=" + rewardAmount +
                ", accountNumber=" + accountNumber +
                '}';
    }
}