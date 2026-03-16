package br.dev.arthdroid1.SpringCRUDProject.repositories;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
