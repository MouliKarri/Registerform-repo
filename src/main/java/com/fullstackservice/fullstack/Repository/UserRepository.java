package com.fullstackservice.fullstack.Repository;

//import com.fullstackservice.fullstack.DTO.SignupDTO;
import com.fullstackservice.fullstack.DTO.SignupDTO;
import com.fullstackservice.fullstack.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
@Repository
public interface UserRepository extends JpaRepository<User,Serializable> {
    User findByUserId(int userId);

    //User findByPassword(String password);

    User findByEmail(String email);

    User save(SignupDTO signbydto);
}
