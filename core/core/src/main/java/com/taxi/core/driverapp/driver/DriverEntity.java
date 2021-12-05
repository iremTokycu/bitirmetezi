package com.taxi.core.driverapp.driver;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@Data
@Table
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tintin_generator")
    @SequenceGenerator(name = "tintin_generator", sequenceName = "tintin_seq", allocationSize = 50)
    private Long id;
    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String surname;
    @Column
    private String password;
    @Column
    private String tcnumber;
    @Column
    private String platenumber;
    @Column
    private String mail;
    @Column
    private String valid;
}
