package com.taxi.core.driverapp.driver;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class DriverEntity {
    @Id
    @Column(name = "id", nullable = false)
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
}
