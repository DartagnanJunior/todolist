package com.study.todlist.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUsersRepository extends JpaRepository <UsersModel, UUID>{

}
