package com.taxi.core.userapp.userhistory;

import com.taxi.core.driverapp.driver.DriverEntity;
import com.taxi.core.userapp.user.UserEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class UserHistoryEntity {
    @Column
    private Long id;

    @Column
    private String source;

    @Column
    private String destination;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;
}
