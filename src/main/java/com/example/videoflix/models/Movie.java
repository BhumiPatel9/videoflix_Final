package com.example.videoflix.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class Movie {

    @Id
    private String id;
    private String title;

    private String description;

    private String type;

    private String year;
    private Boolean featured = false;

    private String banner;

    private String poster;

    private Integer rating;

    private Integer totalRatings;

    private Float rentPrice;

    private Float buyPrice;

    public Movie(){

    }
    public Movie(String id, String title, String description, String type, String year, Boolean featured, String banner, String poster, Integer rating, Integer totalRatings, Float rentPrice, Float buyPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.year = year;
        this.featured = featured;
        this.banner = banner;
        this.poster = poster;
        this.rating = rating;
        this.totalRatings = totalRatings;
        this.rentPrice = rentPrice;
        this.buyPrice = buyPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }

    public Float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Float rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Float buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", year='" + year + '\'' +
                ", featured=" + featured +
                ", banner='" + banner + '\'' +
                ", poster='" + poster + '\'' +
                ", rating=" + rating +
                ", totalRatings=" + totalRatings +
                ", rentPrice=" + rentPrice +
                ", buyPrice=" + buyPrice +
                '}';
    }
}