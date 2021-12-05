package com.taxi.core.userapp.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

    public UserEntity getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        UserEntity userEntity = userEntityRepository.findByUsername(username);

        return userEntity;
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
}
