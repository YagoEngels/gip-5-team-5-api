package User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() { return userRepository.findAll(); }

    public User updateUser(long id, User _user) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setFirstname(_user.firstname);
            user.get().setLastname(_user.firstname);
            user.get().setEmail(_user.firstname);
            user.get().setBirthdate(_user.firstname);
            userRepository.save(user.get());
            return user.get();
        }
        throw new IllegalArgumentException("User already exists");
    }

    public void add(User user){
        List<User> userList = userRepository.findAll();
        for (User currentuser : userList){
            if (currentuser.getId().equals(user.getId())){
                throw new IllegalArgumentException("User already exists");
            }
        }
    }

    public Optional<User> findById(long id) { return userRepository.findById(id); }

    public void removeUser(User user){ userRepository.delete(user); }
}
