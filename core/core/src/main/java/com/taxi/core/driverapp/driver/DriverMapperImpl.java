package com.taxi.core.driverapp.driver;

public class DriverMapperImpl {

    public static DriverEntity toEntity(DriverDTO driverDTO) {
        DriverEntity driverEntity = new DriverEntity();
        driverEntity.setId(driverDTO.getId());
        driverEntity.setName(driverDTO.getName());
        driverEntity.setPassword(driverDTO.getPassword());
        driverEntity.setPlatenumber(driverDTO.getPlatenumber());
        driverEntity.setSurname(driverDTO.getSurname());
        driverEntity.setMail(driverDTO.getMail());
        driverEntity.setTcnumber(driverDTO.getTcnumber());
        driverEntity.setValid(driverDTO.getValid());
        driverEntity.setUsername(driverDTO.getUsername());

        return driverEntity;
    }
}
