package com.example.lets_talk.custom;

/**
 * Created by Hp on 28/2/2019.
 */
public class Location {
    private final Long id;
    private final String name;
    private final String country;

    public Location(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
