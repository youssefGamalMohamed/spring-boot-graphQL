package com.youssef.gamal.springboot.graphql.controllers;

import com.youssef.gamal.springboot.graphql.entities.User;
import com.youssef.gamal.springboot.graphql.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @QueryMapping
    public Iterable<User> findAllUsers() {
        log.info("UserController: findAllUsers()");
        Iterable<User> users = userService.findAll();
        log.info("UserController: findAllUsers() - users: {}", users);
        return users;
    }

    @SchemaMapping(typeName = "Mutation", field = "createUser")
    public User createUser( @Argument String name,
                            @Argument String userName,
                            @Argument String password,
                            @Argument String age) {
        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setPassword(password);
        user.setAge(age);
        log.info("UserController: createUser() - user: {}", user);
        return userService.save(user);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteUser")
    public User deleteUser(@Argument Long id) {
        log.info("UserController: deleteUser() - id: {}", id);
        return userService.deleteById(id);
    }

    @SchemaMapping(typeName = "Mutation", field = "updateUser")
    public User updateUser( @Argument Long id,
                            @Argument String name,
                            @Argument String userName,
                            @Argument String password,
                            @Argument String age) {
        log.info("UserController: updateUser() - id: {}, name: {}, userName: {}, password: {}, age: {}", id, name, userName, password, age);
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setUserName(userName);
        user.setPassword(password);
        user.setAge(age);
        return userService.updateById(id, user);
    }

    @SchemaMapping(typeName = "Mutation", field = "followUser")
    public User followUser(@Argument Long userId, @Argument Long followerId) {
        return userService.follow(userId, followerId);
    }
}
