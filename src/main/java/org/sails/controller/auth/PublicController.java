package org.sails.controller.auth;

import org.sails.entity.DomainUser;
import org.sails.security.service.TokenService;
import org.sails.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Nodirbek on 19.09.2015.
 */

@Controller
@RequestMapping(value = "/public")

public class PublicController {

    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/getAuthToken", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    ResponseEntity welcome(@RequestParam("login") String login,
                           @RequestParam("password") String password) {
        DomainUser domainUser = userService.getUser(login);
        if (domainUser == null) {
            return new ResponseEntity<>("User with such login and password not found",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tokenService.generateToken(domainUser),
                HttpStatus.OK);
    }
}
