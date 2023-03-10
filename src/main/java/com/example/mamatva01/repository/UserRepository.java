package com.example.mamatva01.repository;


import com.example.mamatva01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends JpaRepository<User, Long> {
    public boolean existsByEmail(String email);

    public User findByEmail(String email);
}
