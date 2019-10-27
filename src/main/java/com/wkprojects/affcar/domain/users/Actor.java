package com.wkprojects.affcar.domain.users;


import com.wkprojects.affcar.domain.AbstractAuditingEntity;
import com.wkprojects.affcar.domain.users.enums.ProfessionalSituationEnum;
import com.wkprojects.affcar.domain.vehicules.Vehicule;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTOR_SEQ")
    @SequenceGenerator(sequenceName = "actor_seq", allocationSize = 1, name = "ACTOR_SEQ")
    private Long id;

    @NotNull
    @Column(name = "is_driver")
    private Boolean isDriver;

    @Size(max = 50)
    @Column(name = "firstname", length = 50)
    @NotNull
    private String firstname;

    @Size(max = 50)
    @Column(name = "lastname", length = 50)
    @NotNull
    private String lastname;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Column(name = "age")
    @Range(min = 18, max = 199)
    private Integer age;

    @NotNull
    @Column(name = "work_address")
    private String workAddress;

    @NotNull
    @Column(name = "living_address")
    private String livingAddress;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "professional_situation")
    private ProfessionalSituationEnum professionalSituation;

    @Column(name = "is_married")
    private Boolean isMarried;

    @Column(name = "number_of_children")
    private Integer numberOfChildren;

    @Column(name = "is_profile_completed")
    private Boolean isProfileCompleted;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "INTEREST_ACTORS",
            joinColumns = {@JoinColumn(name = "actor_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "interest_id", referencedColumnName = "id")})
    private Set<Interest> interests = new HashSet<>();

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vehicule> vehicules = new HashSet<>();

    @JoinColumn(name = "user_id")
    @OneToOne(mappedBy = "actor", fetch = FetchType.LAZY)
    private User user;

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

    public Boolean getIsProfileCompleted() {
        return isProfileCompleted;
    }

    public void setIsProfileCompleted(Boolean profileCompleted) {
        isProfileCompleted = profileCompleted;
    }

    public Set<Interest> getInterests() {
        return interests;
    }

    public void setInterests(Set<Interest> interests) {
        this.interests = interests;
    }

    public Set<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", isDriver=" + isDriver +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", workAddress='" + workAddress + '\'' +
                ", livingAddress='" + livingAddress + '\'' +
                ", professionalSituation=" + professionalSituation +
                ", isMarried=" + isMarried +
                ", numberOfChildren=" + numberOfChildren +
                ", interests=" + interests +
                ", vehicules=" + vehicules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(getId(), actor.getId()) &&
                Objects.equals(isDriver, actor.isDriver) &&
                Objects.equals(getFirstname(), actor.getFirstname()) &&
                Objects.equals(getLastname(), actor.getLastname()) &&
                Objects.equals(getPhoneNumber(), actor.getPhoneNumber()) &&
                Objects.equals(getAge(), actor.getAge()) &&
                Objects.equals(getNumberOfChildren(), actor.getNumberOfChildren()) &&
                Objects.equals(getVehicules(), actor.getVehicules()) &&
                Objects.equals(getUser(), actor.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isDriver, getFirstname(), getLastname(), getPhoneNumber(), getAge(), getNumberOfChildren(), getVehicules(), getUser());
    }
}
