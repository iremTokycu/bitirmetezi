package com.taxi.core.userapp.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public-userapp-api")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<Boolean> userSignUp(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.signup(userDTO));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserDTO> userLogin(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.login(userDTO));
    }


}
