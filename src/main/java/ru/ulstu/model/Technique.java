package ru.ulstu.model;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(indexes = {@Index(columnList = "number")})
public class Technique extends BaseEntity {

    private String name;

    private int number;

    private byte availability;

    @OneToMany(mappedBy = "technique")
    private Set<Request> requests;

    @OneToMany(mappedBy = "technique")
    private Set<Supply> supplies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public byte getAvailability() {
        return availability;
    }

    public void setAvailability(byte availability) {
        this.availability = availability;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public Set<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(Set<Supply> supplies) {
        this.supplies = supplies;
    }

    @Override
    public String toString() {
        return name;
    }
}
