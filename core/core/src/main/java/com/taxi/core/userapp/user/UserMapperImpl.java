package com.taxi.core.userapp.user;

public class UserMapperImpl {
    public static UserDTO toDTO(UserEntity userEntity) {

        UserDTO dto = new UserDTO();

        if (userEntity == null) {
            return null;
        }

        dto.setId(userEntity.getId());
        dto.setUsername(userEntity.getUsername());
        dto.setPassword(userEntity.getPassword());
        dto.setName(userEntity.getName());
        dto.setSurname(userEntity.getSurname());
        dto.setMail(userEntity.getMail());

        return dto;
    }

    public static void toEntity(UserDTO user, UserEntity userEntity) {
        userEntity.setId(user.getId());

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setName(user.getName());
        userEntity.setSurname(user.getUsername());
        userEntity.setMail(user.getMail());
    }

    public static UserEntity toEntity(UserDTO user) {
        UserEntity result = new UserEntity();
        result.setId(user.getId());

        result.setUsername(user.getUsername());
        result.setPassword(user.getPassword());
        result.setSurname(user.getSurname());
        result.setName(user.getName());
        result.setMail(user.getMail());

        return result;
    }

}
