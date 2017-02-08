package edu.eci.cosw.spademo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by juanpa_507 on 1/02/17.
 */
@RestController
public class UsersController {

    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }
}
