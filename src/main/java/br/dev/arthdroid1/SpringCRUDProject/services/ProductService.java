package br.dev.arthdroid1.SpringCRUDProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.Product;
import br.dev.arthdroid1.SpringCRUDProject.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Product with id: " + id + " not founded "));
    }
}
