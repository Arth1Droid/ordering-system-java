package br.dev.arthdroid1.SpringCRUDProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {


}
