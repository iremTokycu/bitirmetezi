package com.taxi.core.userapp.user;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ToString
@Entity
@Data
@Table
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tintin_generator")
    @SequenceGenerator(name = "tintin_generator", sequenceName = "tintin_seq", allocationSize = 50)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(unique = true)
    private String mail;

    @Column
    private String valid;




}
