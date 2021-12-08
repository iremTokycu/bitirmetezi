package com.taxi.core.userapp.user;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;


@Transactional
@Service
public class UserService {


    @Autowired
    private UserEntityRepository userEntityRepository;


    @Transactional
    public void createAdminIfNoUser() {
        long users = userEntityRepository.count();

        Boolean exists = (users > 0);

        if (!exists) {

            UserEntity user = new UserEntity();
            user.setUsername("admin");
            user.setPassword("admin");

            userEntityRepository.save(user);
        }
    }




    @Transactional
    public UserEntity findByMail(String mail) {
        return userEntityRepository.findByMail(mail);
    }

    public UserDTO getCurrentUser() {
        String mail = SecurityContextHolder.getContext().getAuthentication().getName();

        UserEntity userEntity = userEntityRepository.findByMail(mail);

        return UserMapperImpl.toDTO(userEntity);
    }

    @Transactional
    public Boolean signup(UserDTO userDTO) {

        UserEntity userEntity = userEntityRepository.findByMail(userDTO.getMail());

        if(userEntity == null) {
            UserEntity result = UserMapperImpl.toEntity(userDTO);
            userEntityRepository.save(result);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Transactional
    public String createToken(String mail, String password) {
        String tokenString = mail + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(tokenString.getBytes());
    }


    @Transactional
    public UserDTO login(UserDTO userDTO) {

        UserEntity userEntity = userEntityRepository.findByMail(userDTO.getMail());

        if(userEntity != null) {
            String token = createToken(userEntity.getMail(), userEntity.getPassword());
            userEntity.setValid(token);
            userDTO.setValid(token);
            userEntityRepository.save(userEntity);
            return userDTO;
        }

        return null;
    }
}
