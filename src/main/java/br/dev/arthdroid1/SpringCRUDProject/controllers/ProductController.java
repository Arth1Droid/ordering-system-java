package br.dev.arthdroid1.SpringCRUDProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.Product;
import br.dev.arthdroid1.SpringCRUDProject.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll();
        return ResponseEntity.ok().body(products);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product productsFound = productService.findById(id);
        return  ResponseEntity.ok().body(productsFound);

    }
}
