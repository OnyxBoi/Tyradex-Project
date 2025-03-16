package com.security.repository;


import com.security.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    User findByClaimToken(String token);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO users_roles (users_id, roles_id) VALUES (?1, ?2);", nativeQuery = true)
    public void linkUserRoles(@RequestParam Long users_id, @RequestParam Long roles_id);
}
