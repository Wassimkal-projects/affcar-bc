package com.wkprojects.affcar.domain.vehicules;

import com.wkprojects.affcar.domain.AbstractAuditingEntity;
import com.wkprojects.affcar.domain.users.Actor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "vehicules")
public class Vehicule extends AbstractAuditingEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VEHICULE_SEQ")
    @SequenceGenerator(sequenceName = "vehicule_seq", allocationSize = 1, name = "VEHICULE_SEQ")
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "brand")
    private String brand;

    @Size(max = 50)
    @Column(name = "model")
    private String model;

    @NotNull
    @Column(name = "fabrication_date")
    private Date fabricationDate;

    @Column(name = "color")
    private String color;

    @Column(name = "insurance_company")
    private String insuranceCompany;

    @Column(name = "kilometers_traveled")
    private BigDecimal kilometersTraveled;

    @JoinColumn(name = "actor_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Actor actor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getKilometersTraveled() {
        return kilometersTraveled;
    }

    public void setKilometersTraveled(BigDecimal kilometersTraveled) {
        this.kilometersTraveled = kilometersTraveled;
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

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fabricationDate=" + fabricationDate +
                ", color='" + color + '\'' +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", kilometersTraveled='" + kilometersTraveled + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicule)) return false;
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(getId(), vehicule.getId()) &&
                Objects.equals(getBrand(), vehicule.getBrand()) &&
                Objects.equals(getModel(), vehicule.getModel()) &&
                Objects.equals(getFabricationDate(), vehicule.getFabricationDate()) &&
                Objects.equals(getColor(), vehicule.getColor()) &&
                Objects.equals(getInsuranceCompany(), vehicule.getInsuranceCompany()) &&
                Objects.equals(getKilometersTraveled(), vehicule.getKilometersTraveled());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getFabricationDate(), getColor(), getInsuranceCompany(), getKilometersTraveled());
    }
}
