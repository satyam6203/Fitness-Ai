package com.fitness.userservice.Repo;

import com.fitness.userservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    boolean existsByEmail(String email);
}
