package com.buschmais.gymmanagement.user;

import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(String firstname, String lastname, User.UserRole role) {
        User user = new User(firstname, lastname, role);
        return this.userRepository.save(user);
    }
}
