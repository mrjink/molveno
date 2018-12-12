package com.molvenolakeresort.controllers.generic;

import com.molvenolakeresort.controllers.ControllerPingTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login/")
public class LoginController implements ControllerPingTest {
    @GetMapping("auth")
    public
}
