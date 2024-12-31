package com.example.course.services;


import com.example.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.repositories.UserRepository;
import com.example.course.entities.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> optionalUser = repository.findById(id);
        return optionalUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User updatedUser){
        User currentUser = repository.getReferenceById(id);
        updateData(currentUser, updatedUser);
        return repository.save(currentUser);
    }

    private void updateData(User currentUser, User updatedUser){
        currentUser.setName(updatedUser.getName());
        currentUser.setEmail(updatedUser.getEmail());
        currentUser.setPhone(updatedUser.getPhone());
    }
}
