package br.dev.arthdroid1.SpringCRUDProject.services;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.Order;
import br.dev.arthdroid1.SpringCRUDProject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Order with id: " + id + " not founded "));
    }
}
