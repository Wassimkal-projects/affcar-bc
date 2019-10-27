package com.wkprojects.affcar.service.dto.vehicules;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class VehiculeDto {

    private Long id;

    @NotNull
    private String brand;

    private String model;

    @NotNull
    private Date fabricationDate;

    private String color;

    private String insuranceCompany;

    private BigDecimal kilometersTraveled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(Date fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public BigDecimal getKilometersTraveled() {
        return kilometersTraveled;
    }

    public void setKilometersTraveled(BigDecimal kilometersTraveled) {
        this.kilometersTraveled = kilometersTraveled;
    }

    @Override
    public String toString() {
        return "VehiculeDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fabricationDate=" + fabricationDate +
                ", color='" + color + '\'' +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", kilometersTraveled=" + kilometersTraveled +
                '}';
    }
}
