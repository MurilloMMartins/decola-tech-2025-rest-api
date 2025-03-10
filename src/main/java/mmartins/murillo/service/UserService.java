package mmartins.murillo.service;

import mmartins.murillo.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

}
