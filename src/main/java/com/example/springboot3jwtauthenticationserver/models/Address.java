package com.example.springboot3jwtauthenticationserver.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.user_id;
    }

    public void setUserId(Long user_id) {
        this.user_id = user_id;
    }

    public String getCountry(String country) {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity(String city) {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress(String address) {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
