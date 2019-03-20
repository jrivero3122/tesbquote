//package com.tesbquote.tesbquote.models;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name= "rate")
//public class Rate {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    @Column(name = "3_rate")
//    private Float rate;
//
//    @ManyToOne
//    private User user;
//
//    @ManyToOne
//    private RateFactor rateFactor;
//
//    public Rate(){
//
//    }
//
//    public Rate(Float rate) {
//        this.rate = rate;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public Float getRate() {
//        return rate;
//    }
//
//    public void setRate(Float rate) {
//        this.rate = rate;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public RateFactor getRateFactor() {
//        return rateFactor;
//    }
//
//    public void setRateFactor(RateFactor rateFactor) {
//        this.rateFactor = rateFactor;
//    }
//}
