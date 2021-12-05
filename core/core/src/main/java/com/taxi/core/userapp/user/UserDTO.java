package com.taxi.core.userapp.user;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;


@Data
@ToString
public class UserDTO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String mail;
    private String valid;

}
