package com.taxi.core.request;


import com.taxi.core.userapp.user.UserEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RequestEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;



}
