package com.taxi.core.driverapp.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Driver;
import java.util.Base64;


@Transactional
@Service
public class DriverService {

    @Autowired
    private DriverEntityRepository driverEntityRepository;

    @Transactional
    public DriverEntity findByMail(String mail) {
        return driverEntityRepository.findByMail(mail);
    }


    @Transactional
    public Boolean signup(DriverDTO driverDTO) {

        DriverEntity driverEntity = driverEntityRepository.findByMail(driverDTO.getMail());

        if(driverEntity == null) {
            DriverEntity result = DriverMapperImpl.toEntity(driverDTO);
            driverEntityRepository.save(result);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public String createToken(String mail, String password) {
        String tokenString = mail + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(tokenString.getBytes());
    }


    @Transactional
    public DriverDTO login(DriverDTO driverDTO) {

        DriverEntity driverEntity = driverEntityRepository.findByMail(driverDTO.getMail());

        if(driverEntity != null) {
            String token = createToken(driverEntity.getMail(), driverEntity.getPassword());
            driverEntity.setValid(token);
            driverDTO.setValid(token);
            driverEntityRepository.save(driverEntity);
            return driverDTO;
        }

        return null;
    }
}
