package com.bit.backend.dtos;

import java.time.LocalDate;

public class FeedbackAndRatingDto {

    private long id;
    private LocalDate date;
    private String user;
    private String rating;
    private String feedbackNote;

    public FeedbackAndRatingDto() {
    }

    public FeedbackAndRatingDto(long id, LocalDate date, String user, String rating, String feedbackNote) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.rating = rating;
        this.feedbackNote = feedbackNote;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedbackNote() {
        return feedbackNote;
    }

    public void setFeedbackNote(String feedbackNote) {
        this.feedbackNote = feedbackNote;
    }
}
