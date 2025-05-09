package com.bit.backend.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Feedback_rating")
public class FeedbackAndRatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "user")
    private String user;

    @Column(name = "ratings")
    private String rating;

    @Column(name = "feedback_note")
    private String feedbackNote;

    public FeedbackAndRatingEntity() {
    }

    public FeedbackAndRatingEntity(Long id, LocalDate date, String user, String rating, String feedbackNote) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.rating = rating;
        this.feedbackNote = feedbackNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
