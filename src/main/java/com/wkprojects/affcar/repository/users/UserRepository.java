/**
 * Copyright (c) 2019. CreatedBy Wassim KALBOUSSI.  All rights reserved.
 */

package com.wkprojects.affcar.repository.users;

import com.wkprojects.affcar.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from users as u where u.email= :email", nativeQuery = true)
    Optional<User> findOneByEmail(@Param("email") String email);

    @Query(value = "select * from users as u where lower(u.email)= :email", nativeQuery = true)
    Optional<User> findOneByEmailIgnoreCase(@Param("email") String email);

    @Query(value = "select * from users as u where u.email= :email", nativeQuery = true)
    Optional<User> findOneWithAuthoritiesByEmail(@Param("email") String email);

    @Query(value = "select * from users as u where u.activation_key = :activationKey", nativeQuery = true)
    Optional<User> findOneByActicationKey(@Param("activationKey") String activationKey);

    @Query(value = "select * from users as u where u.email = :email", nativeQuery = true)
    Optional<User> findOneByUserEmail(@Param("email") String email);

    @Query(value = "select * from users as u where u.reset_key = :resetKey", nativeQuery = true)
    Optional<User> findOneByResetKey(@Param("resetKey") String resetKey);
}
