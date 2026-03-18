package br.dev.arthdroid1.SpringCRUDProject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
