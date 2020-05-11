package ru.ulstu.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Supply extends BaseEntity {


    @Temporal(TemporalType.DATE)
    private Date date;

    private int number;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = true)
    private Provider provider;

    @ManyToOne
    @JoinColumn(name = "technique_id", nullable = true)
    private Technique technique;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Technique getTechnique() {
        return technique;
    }

    public void setTechnique(Technique technique) {
        this.technique = technique;
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
