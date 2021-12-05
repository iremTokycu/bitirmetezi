package com.taxi.core.driverapp.driver;

import lombok.Data;

@Data
public class DriverDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String tcnumber;
    private String platenumber;
    private String mail;
    private String valid;
}
