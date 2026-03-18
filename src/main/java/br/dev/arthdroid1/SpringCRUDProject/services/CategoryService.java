package br.dev.arthdroid1.SpringCRUDProject.services;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.Category;
import br.dev.arthdroid1.SpringCRUDProject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Category with id: " + id + " not founded "));
    }
}
