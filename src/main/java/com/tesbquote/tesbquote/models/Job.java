package com.tesbquote.tesbquote.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String job;

    @OneToMany
    @JoinColumn(name = "job_id")
    private List<RateFactor> rateFactors = new ArrayList<>();

    public Job(){

    }

    public Job(String job) {
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<RateFactor> getRateFactors() {
        return rateFactors;
    }
}
