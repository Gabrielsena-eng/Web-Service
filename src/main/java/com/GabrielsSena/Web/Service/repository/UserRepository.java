package com.GabrielsSena.Web.Service.repository;

import com.GabrielsSena.Web.Service.Entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);
    Optional<User> findByPhone(String phone);

    @Transactional
    void deleteByEmail(String email);


}
