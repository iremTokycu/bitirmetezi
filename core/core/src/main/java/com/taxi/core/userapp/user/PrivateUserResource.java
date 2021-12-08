package com.taxi.core.userapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userapp-api")
public class PrivateUserResource {

    @Autowired
    private UserService userService;


    @GetMapping(path = "/deneme")
    public ResponseEntity<UserDTO> deneme() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @GetMapping(path = "/login")
    public ResponseEntity<UserDTO> login() {

        UserEntity user = userService.findByMail(SecurityContextHolder.getContext().getAuthentication().getName());

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setValid(user.getValid());
        userDTO.setSurname(user.getSurname());
        userDTO.setName(user.getName());



        return ResponseEntity.ok(userDTO);
    }
}
