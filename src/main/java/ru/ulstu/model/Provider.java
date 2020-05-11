package ru.ulstu.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Provider extends BaseEntity {

    private String nameOrganization;

    private String surname;

    private String name;

    private String patronymic;

    private String telephone;

    private String address;

    @OneToMany(mappedBy = "provider")
    private Set<Supply> supplies;

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(Set<Supply> supplies) {
        this.supplies = supplies;
    }
}
