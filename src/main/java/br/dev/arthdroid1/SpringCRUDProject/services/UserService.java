package br.dev.arthdroid1.SpringCRUDProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.User;
import br.dev.arthdroid1.SpringCRUDProject.repositories.UserRepository;
import br.dev.arthdroid1.SpringCRUDProject.services.exceptions.DatabaseException;
import br.dev.arthdroid1.SpringCRUDProject.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public User insert(User user) {
    	return repository.save(user);
    }
    
    public void delete(Long id) {
    	try {
    		repository.deleteById(id);
    	}
    	catch(EmptyResultDataAccessException ex) {
    		throw new ResourceNotFoundException(id);
    	}
    	catch(DataIntegrityViolationException ex) {
    		throw new DatabaseException(ex.getMessage());
    	}
    		
    }
    
    public User update(Long id, User user) {
    	try {
	    	User entity = repository.getReferenceById(id);
	    	updateDate(entity,user);
	    	return repository.save(entity);
    	}
    	catch(EntityNotFoundException ex) {
    		throw new ResourceNotFoundException(id);
    	}
    }

    private void updateDate(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}

	public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException( id));
    }
}
