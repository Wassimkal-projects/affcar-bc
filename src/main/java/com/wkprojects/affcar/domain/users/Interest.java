package com.wkprojects.affcar.domain.users;

import com.wkprojects.affcar.domain.AbstractAuditingEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "interests")
public class Interest extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INTEREST_SEQ")
    @SequenceGenerator(sequenceName = "interest_seq", allocationSize = 1, name = "INTEREST_SEQ")
    private Long id;

    @Column(name = "code")
    private String code;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Actor> actors = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interest)) return false;
        Interest interest = (Interest) o;
        return Objects.equals(getId(), interest.getId()) &&
                Objects.equals(getCode(), interest.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode());
    }
}
