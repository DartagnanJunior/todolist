package com.study.todolist.users;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity create(@RequestBody UsersModel user){
       var userFiltered = this.usersRepository.findByUserName(user.getUserName());

       if(userFiltered != null){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado.");
       } else {
           user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
           return ResponseEntity.status(HttpStatus.CREATED).body(this.usersRepository.save(user));
       }

    }
}
