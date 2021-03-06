package com.kpi.parking.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "creation_date")
    private LocalDate creationDate;
    private int amount;
    private String status;
    private String type;

    public Payment(LocalDate creationDate, int amount, String status, String type) {
        this.creationDate = creationDate;
        this.amount = amount;
        this.status = status;
        this.type = type;
    }

    public Payment(int id, LocalDate creationDate, int amount, String status, String type) {
        this.id = id;
        this.creationDate = creationDate;
        this.amount = amount;
        this.status = status;
        this.type = type;
    }

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return id == payment.id &&
                amount == payment.amount &&
                creationDate.equals(payment.creationDate) &&
                status.equals(payment.status) &&
                type.equals(payment.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, amount, status, type);
    }
}
