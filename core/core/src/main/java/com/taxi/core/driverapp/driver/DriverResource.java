package com.taxi.core.driverapp.driver;

import com.taxi.core.userapp.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Driver;

@RestController
@RequestMapping("/public-driverapp-api")
public class DriverResource {

    @Autowired
    private DriverService driverService;

    @PostMapping(path = "/signup")
    public ResponseEntity<Boolean> driverSignUp(@RequestBody DriverDTO driverDTO) {
        return ResponseEntity.ok(driverService.signup(driverDTO));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<DriverDTO> driverLogin(@RequestBody DriverDTO driverDTO) {
        return ResponseEntity.ok(driverService.login(driverDTO));
    }
}
