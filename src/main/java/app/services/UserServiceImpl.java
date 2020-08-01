package app.services;

import app.models.Users;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
@Autowired
private final UserRepository userRepository;

@Autowired
public  UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
}
    @Override
    public List<Users> getAll() {
        return (List<Users>) userRepository.findAll();
    }

    @Override
    public void addUser(Users users) {

    }
}
