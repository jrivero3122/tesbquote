package com.tesbquote.tesbquote.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Rate_Factor")
public class RateFactor {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String rateFactor;

    @ManyToOne
    private Job job;

    @OneToMany
    @JoinColumn(name = "rate_factor_id")
    private List<Rate> rateFactors = new ArrayList<>();

    public  RateFactor(){

    }

    public RateFactor(String rateFactor) {
        this.rateFactor = rateFactor;
    }

    public int getId() {
        return id;
    }

    public String getRateFactor() {
        return rateFactor;
    }

    public void setRateFactor(String rateFactor) {
        this.rateFactor = rateFactor;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<Rate> getRateFactors() {
        return rateFactors;
    }
}
