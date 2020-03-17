package springIoC.services;

import springIoC.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springIoC.repositories.UserRepository;

import java.util.List;

@Component
public class UserContainer {

    @Autowired
    UserRepository userRepository;

    public void add(User user){
        userRepository.save(user);
    }

    public List<User> out(){
        return (List<User>) userRepository.findAll();
    }
}
