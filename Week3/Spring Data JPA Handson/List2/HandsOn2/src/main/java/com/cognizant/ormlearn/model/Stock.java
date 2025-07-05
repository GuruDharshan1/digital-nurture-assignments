package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stId;
    private String stCode;
    private Date stDate;
    private double stOpen;
    private double stClose;
    private long stVolume;

    // Getters and Setters
    public int getStId() { return stId; }
    public void setStId(int stId) { this.stId = stId; }
    public String getStCode() { return stCode; }
    public void setStCode(String stCode) { this.stCode = stCode; }
    public Date getStDate() { return stDate; }
    public void setStDate(Date stDate) { this.stDate = stDate; }
    public double getStOpen() { return stOpen; }
    public void setStOpen(double stOpen) { this.stOpen = stOpen; }
    public double getStClose() { return stClose; }
    public void setStClose(double stClose) { this.stClose = stClose; }
    public long getStVolume() { return stVolume; }
    public void setStVolume(long stVolume) { this.stVolume = stVolume; }

    @Override
    public String toString() {
        return stCode + " | " + stDate + " | " + stOpen + " | " + stClose + " | " + stVolume;
    }
}
