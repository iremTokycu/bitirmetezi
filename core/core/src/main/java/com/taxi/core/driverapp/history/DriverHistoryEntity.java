package com.taxi.core.driverapp.history;

import com.taxi.core.driverapp.driver.DriverEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DriverHistoryEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String source;
    @Column
    private String destination;
    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "driverid")
    private DriverEntity driverEntity;

}
