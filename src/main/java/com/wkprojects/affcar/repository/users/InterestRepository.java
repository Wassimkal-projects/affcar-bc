package com.wkprojects.affcar.repository.users;

import com.wkprojects.affcar.domain.users.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest,Long> {
}
