package com.wkprojects.affcar.repository.vehicules;

import com.wkprojects.affcar.domain.vehicules.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
