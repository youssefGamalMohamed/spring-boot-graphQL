package com.youssef.gamal.springboot.graphql.repos;

import com.youssef.gamal.springboot.graphql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
