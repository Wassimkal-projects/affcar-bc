package com.wkprojects.affcar.service.dto.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wkprojects.affcar.domain.users.enums.ProfessionalSituationEnum;
import com.wkprojects.affcar.service.dto.vehicules.VehiculeDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class ActorDto {

    private Long id;

    @NotNull
    private Boolean isDriver;

    @NotNull
    @Size(max = 50)
    private String firstname;

    @NotNull
    @Size(max = 50)
    private String lastname;

    @NotNull
    private String phoneNumber;

    @NotNull
    private Integer age;

    @NotNull
    private String workAddress;

    @NotNull
    private String livingAddress;

    private Boolean isProfileCompleted;

    @NotNull
    private ProfessionalSituationEnum professionalSituation;

    private Boolean isMarried;

    private Integer numberOfChildren;

    private Set<InterestDto> interests = new HashSet<>();

    private Set<VehiculeDto> vehicules = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsDriver() {
        return isDriver;
    }

    public void setIsDriver(Boolean driver) {
        isDriver = driver;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getLivingAddress() {
        return livingAddress;
    }

    public void setLivingAddress(String livingAddress) {
        this.livingAddress = livingAddress;
    }

    public Boolean getIsProfileCompleted() {
        return isProfileCompleted;
    }

    public void setIsProfileCompleted(Boolean profileCompleted) {
        isProfileCompleted = profileCompleted;
    }

    public ProfessionalSituationEnum getProfessionalSituation() {
        return professionalSituation;
    }

    public void setProfessionalSituation(ProfessionalSituationEnum professionalSituation) {
        this.professionalSituation = professionalSituation;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Boolean married) {
        isMarried = married;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Set<InterestDto> getInterests() {
        return interests;
    }

    public void setInterests(Set<InterestDto> interests) {
        this.interests = interests;
    }

    public Set<VehiculeDto> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<VehiculeDto> vehicules) {
        this.vehicules = vehicules;
    }

    @Override
    public String toString() {
        return "ActorDto{" +
                "id=" + id +
                ", isDriver=" + isDriver +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", workAddress='" + workAddress + '\'' +
                ", livingAddress='" + livingAddress + '\'' +
                ", isProfileCompleted=" + isProfileCompleted +
                ", professionalSituation=" + professionalSituation +
                ", isMarried=" + isMarried +
                ", numberOfChildren=" + numberOfChildren +
                ", interests=" + interests +
                ", vehicules=" + vehicules +
                '}';
    }
}
