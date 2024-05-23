package com.study.todlist.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersRepository usersRepository;

    @PostMapping("")
    public UsersModel create(@RequestBody UsersModel user){
       var userCreated = this.usersRepository.save(user);
       return userCreated;
    }
}
