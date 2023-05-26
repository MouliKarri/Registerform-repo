package com.fullstackservice.fullstack.Controller;

import com.fullstackservice.fullstack.DTO.LoginDTO;
import com.fullstackservice.fullstack.DTO.SignupDTO;
import com.fullstackservice.fullstack.Entity.User;
import com.fullstackservice.fullstack.Service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/save")
    public User save(@RequestBody SignupDTO signbydto) {
        return userService.saveDetails(signbydto);
    }
    @PostMapping(value = "/signup")
    public ResponseEntity<MyResponse> signup(@RequestBody SignupDTO signupDTO) {
        int response = userService.signUp(signupDTO);
        if (response == 1) {
            return ResponseEntity.ok(new MyResponse("saved user details"));
        } else {
            return ResponseEntity.ok(new MyResponse("already exists "));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<MyResponse> login(@RequestBody LoginDTO loginDTO) {
        int responses = userService.logIn(loginDTO);
        if (responses == 1) {
            return ResponseEntity.ok(new MyResponse("login successful"));
        } else {
            return ResponseEntity.ok(new MyResponse("failed to login"));
        }
    }
}

    /*@PostMapping(value = "/login")
    public String logIn(@RequestBody final LoginDTO loginbydto) {
        int response = userService.logIn(loginbydto);
        if (response == 1) {
            return "successful";
        } else {
            return "failed to login";
        }
    }*/

    /*@PostMapping(value = "/save")
    public User save(@RequestBody User user) {
        return userService.saveDetails(user);
    }


    @PostMapping(value = "/signup")
    public String signUp(@RequestBody final User user) {
        int response = userService.signUp(user);
        if (response == 1) {
            return " Signup successfull";
        } else {
            return "User already exists";
        }
    }

    @PostMapping(value = "/logIn")
    public String logIn(@RequestBody final User user) {
        int response = userService.logIn(user);
        if (response == 1) {
            return "login successful";
        } else {
            return "failed to login";
        }
    }*/





