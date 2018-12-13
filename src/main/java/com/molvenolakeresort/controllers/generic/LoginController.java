package com.molvenolakeresort.controllers.generic;

import com.molvenolakeresort.controllers.ControllerPingTest;
import com.molvenolakeresort.models.generic.security.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/login/")
public class LoginController implements ControllerPingTest {

    @GetMapping(value = "/session/{providedSessionId}")
    public ResponseEntity getUserAndSessionId(UsernamePasswordAuthenticationToken principal,
                                              HttpServletRequest httpServletRequest, @PathVariable("providedSessionId") String providedSessionId) {

        ResponseEntity entity;

        // Session ID
        String sessionId = httpServletRequest.getRequestedSessionId();

        if(sessionId.equals(providedSessionId)) {
            // Username
            String name = principal.getName();
            entity = new ResponseEntity<String>(name, HttpStatus.OK);
        }

        entity = new ResponseEntity(HttpStatus.NOT_FOUND);
        return entity;
    }

    private class Logon
    {
        private boolean status;
        private String username;

        public Logon() {
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    @GetMapping(value = "/status")
    public ResponseEntity getUsernameSessionId(UsernamePasswordAuthenticationToken principal,
                                              HttpServletRequest httpServletRequest) {

        ResponseEntity entity;

        // Session ID
        String sessionId = httpServletRequest.getRequestedSessionId();

        if(!sessionId.isEmpty())
        {
            // Username
            String name = principal.getName();
            entity = new ResponseEntity<String>(name, HttpStatus.OK);
        }
        else {
            entity = new ResponseEntity(null,HttpStatus.NOT_FOUND);
        }
        return entity;
    }
}
