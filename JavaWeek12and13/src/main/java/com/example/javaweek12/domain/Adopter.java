package com.example.javaweek12.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Adopter {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long id;
   @Column (name = "adopterName")
    private String adopterName;
    private long phoneNumber;
    @OneToMany(mappedBy = "adopter", fetch = FetchType.EAGER)
    private List<Pet> pets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
