package com.taxi.core.driverapp.suitor;

import com.taxi.core.driverapp.driver.DriverEntity;
import com.taxi.core.request.RequestEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SuitorEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "driverid")
    private DriverEntity driverEntity;

    @OneToOne
    @JoinColumn(name = "requestid")
    private RequestEntity requestEntity;
}
