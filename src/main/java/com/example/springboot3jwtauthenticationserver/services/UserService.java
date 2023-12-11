package com.example.springboot3jwtauthenticationserver.services;

import com.example.springboot3jwtauthenticationserver.dto.UserCreateRequest;
import com.example.springboot3jwtauthenticationserver.dto.UserUpdateRequest;
import com.example.springboot3jwtauthenticationserver.models.User;
import com.example.springboot3jwtauthenticationserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * display the list of resources
     */
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        this.userRepository.findAll().forEach(item -> users.add(item));
        return users;
    }

    /**
     * find specific resource by id
     **/
    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    /**
     * find specific resource by email
     **/
    public Optional<User> getUserByEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }

    /**
     * find specific unique email by id
     **/
    public Optional<User> getUniqueEmailById(Long id, String email) {
        return this.userRepository.findUniqueEmail(id, email);
    }

    /**
     * create new resource
     **/
    public void createUser(UserCreateRequest documents) {
        User user = new User();
        user.setName(documents.getName());
        user.setEmail(documents.getEmail());
        user.setPassword(documents.getPassword());

        this.userRepository.save(user);
    }

    /**
     * update specific resource
     **/
    public void updateUser(Long id, UserUpdateRequest documents) {
        User user = this.userRepository.findById(id).get();
        user.setName(documents.getName());
        user.setEmail(documents.getEmail());

        this.userRepository.save(user);
    }

    /**
     * delete a specific resource
     */
    public void destroyUser(Long id) {
        this.userRepository.deleteById(id);
    }
}
