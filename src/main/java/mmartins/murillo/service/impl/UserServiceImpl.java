package mmartins.murillo.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import mmartins.murillo.domain.repository.UserRepository;
import mmartins.murillo.domain.model.User;
import mmartins.murillo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        return userRepository.save(userToCreate);
    }

}
