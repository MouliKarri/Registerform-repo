package com.fullstackservice.fullstack.Service;
import com.fullstackservice.fullstack.DTO.LoginDTO;
import com.fullstackservice.fullstack.DTO.SignupDTO;
import com.fullstackservice.fullstack.Entity.User;
import com.fullstackservice.fullstack.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveDetails(@RequestBody SignupDTO signbydto) {
        return userRepository.save(signbydto);
    }
    public int signUp(final SignupDTO signbydto){
        User saveduser = userRepository.findByEmail(signbydto.getEmail());
        if(ObjectUtils.isEmpty(saveduser)){
            User newuser = new User();
            newuser.setFullname(signbydto.getFullname());
            newuser.setName(signbydto.getName());
            newuser.setEmail(signbydto.getEmail());
            newuser.setPassword(signbydto.getPassword());
            newuser.setNumber(signbydto.getNumber());
            userRepository.save(newuser);
            return 1;
        }else{
            return 100;
        }
    }
    public int logIn(final LoginDTO loginbydto){
        User savedusers = userRepository.findByEmail(loginbydto.getEmail());
        if(!ObjectUtils.isEmpty(savedusers)){
            if (savedusers.getPassword().equals(loginbydto.getPassword())){
                return 1;
            }
        }return 100;
    }
}
    /*public User saveDetails(@RequestBody User user) {
        return userRepository.save(user);
    }

    public int signUp(final User user) {
        User savedUser = userRepository.findByEmail(user.getEmail());
        if (ObjectUtils.isEmpty(savedUser)) {
            userRepository.save(user);
            return 1;
        } else {
            return 100;
        }
    }

    public int logIn(final User user) {
        User saveduser = userRepository.findByEmail(user.getEmail());
        if (!ObjectUtils.isEmpty(saveduser)) {
            if (saveduser.getPassword().equals(user.getPassword())) {
                return 1;
            }
        }
        return 2;
    }
        /*.....no use.....
        else if(){
            //userRepository.save(user);
            return 2;
        }
        else
        {
            return 3;
        }!ObjectUtils.isEmpty(savedusers*/



