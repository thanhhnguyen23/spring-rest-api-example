package com.thanhhnguyen23.review;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private int rating;
    private String description;
    
    protected Review(){
        id = null;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
