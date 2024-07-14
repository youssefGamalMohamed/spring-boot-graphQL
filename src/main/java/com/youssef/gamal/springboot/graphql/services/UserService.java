package com.youssef.gamal.springboot.graphql.services;


import com.youssef.gamal.springboot.graphql.entities.User;
import com.youssef.gamal.springboot.graphql.repos.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepo userRepo;

    public Iterable<User> findAll() {
        log.info("UserService: findAll()");
        return userRepo.findAll();
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public User deleteById(@Argument Long id) {
        log.info("UserService: deleteById({})", id);
        User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        userRepo.deleteById(id);
        return user;
    }

    public User updateById(Long id, User user) {
        log.info("UserService: updateById({}, {})", id, user);
        User existing_user = userRepo.findById(id)
                .orElseThrow();
        existing_user.setName(user.getName());
        existing_user.setAge(user.getAge());
        existing_user.setUserName(user.getUserName());
        existing_user.setPassword(user.getPassword());
        userRepo.save(existing_user);
        return existing_user;
    }
}
