package com.jacobebel.jukeboxd.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="albums")
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
    @NotBlank(message="Title must not be blank.")
    @Size(min = 1, max = 200, message="Title must be 1-200 characters.")
    private String title;
    
    @NotBlank(message="Artist must not be blank.")
    @Size(min = 2, max = 100, message="Artist must be 2-100 characters.")
    private String artist;
    
    @NotBlank(message="Review must not be blank.")
    @Size(min = 2, max = 500, message="Review must be 2-500 chatacters.")
    @Column(columnDefinition="Text")
    private String review;
    
    @NotNull(message="Rating must not be blank.")
    @Min(value = 1, message="Rating must be between 1 and 5.")
    @Max(value = 5, message="Rating must be between 1 and 5.")
    private Integer rating;
    
    @NotNull(message="Date must not be blank.")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    public Album() {}
    
    public Album(
    		@NotBlank(message="Title must not be blank.") @Size(min = 1, max = 200, message="Title must be 1-200 characters.") String title,         
    		@NotBlank(message="Artist must not be blank.") @Size(min = 2, max = 100, message="Author must be 2-100 characters.") String artist,
    		@NotBlank(message="Review must not be blank.") @Size(min = 2, max = 500, message="Review must be 2-500 characters.") String review,
    		@NotNull(message="Rating must not be blank.") @Min(value = 1, message="Rating must be between 1 and 5.") @Max(value = 5, message="Rating must be between 1 and 5.") Integer rating, 
    		@NotNull(message="Date must not be blank.") Date date) {
        this.title = title;
        this.artist = artist;
        this.review = review;
        this.rating= rating;
        this.date = date;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
    
}
