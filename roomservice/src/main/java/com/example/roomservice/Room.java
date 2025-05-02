package com.example.roomservice;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String size;
    private Integer capacity;


    @ElementCollection
    private List<String> amenities;

    Room() {}

    public Room(String name, String size, Integer capacity, List<String> amenities) {
        this.name = name;
        this.size = size;
        this.capacity = capacity;
        
        this.amenities = amenities;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }


    public List<String> getAmenities() { return amenities; }
    public void setAmenities(List<String> amenities) { this.amenities = amenities; }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", capacity=" + capacity +
                
                ", amenities=" + amenities +
                '}';
    }
}
