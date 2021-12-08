package com.taxi.core.userapp.user;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByMailAndPassword(String mail, String password);

    UserEntity findByUsername(String username);

    UserEntity findByMail(String mail);

}
