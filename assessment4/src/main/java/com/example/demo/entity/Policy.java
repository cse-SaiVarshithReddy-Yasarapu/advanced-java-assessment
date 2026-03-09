package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;
    private String policyType;
    private double premiumAmount;
    private double coverageAmount;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Policy(){}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getPolicyNumber() { return policyNumber; }

    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getPolicyType() { return policyType; }

    public void setPolicyType(String policyType) { this.policyType = policyType; }

    public double getPremiumAmount() { return premiumAmount; }

    public void setPremiumAmount(double premiumAmount) { this.premiumAmount = premiumAmount; }

    public double getCoverageAmount() { return coverageAmount; }

    public void setCoverageAmount(double coverageAmount) { this.coverageAmount = coverageAmount; }

    public LocalDate getStartDate() { return startDate; }

    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }

    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }
}