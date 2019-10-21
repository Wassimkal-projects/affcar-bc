/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.repository.users;

import com.wkprojects.affcar.domain.users.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
