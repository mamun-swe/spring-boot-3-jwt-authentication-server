package com.example.springboot3jwtauthenticationserver.repositories;

import com.example.springboot3jwtauthenticationserver.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
     * find resources by user_id
     **/
    @Query(value = "SELECT * FROM address WHERE address.user_id=?1", nativeQuery = true)
    Optional<Address> findAll(Long user_id);

    /**
     * find specific resource by user_id
     **/
    @Query(value = "SELECT * FROM address WHERE address.id=?1 AND address.user_id=?2 LIMIT 1", nativeQuery = true)
    Optional<Address> findById(Long id, Long user_id);
}
