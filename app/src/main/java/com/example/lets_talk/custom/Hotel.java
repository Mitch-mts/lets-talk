package com.example.lets_talk.custom;

import java.util.Date;

public class Hotel {
    private Long id;
    private String name;
    private String location;
    private Date createdDate;

    public Hotel() {
    }

    private Hotel(Long id, String name, String location, Date createdDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.createdDate = createdDate;
    }

    public static Hotel of(Long id, String name, String location, Date createdDate) {
        return new Hotel(id, name, location, createdDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
