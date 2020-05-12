package com.deb.diaoyu.demo.repository;

import com.deb.diaoyu.demo.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findAdminByUsernameAndPassword(String username, String password);

    boolean existsAdminByUsername(String username);
}
