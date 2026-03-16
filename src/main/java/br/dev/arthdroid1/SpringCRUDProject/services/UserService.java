package br.dev.arthdroid1.SpringCRUDProject.services;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.User;
import br.dev.arthdroid1.SpringCRUDProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("User with id: " + id + " not founded "));
    }
}
