package br.dev.arthdroid1.SpringCRUDProject.repositories;

import br.dev.arthdroid1.SpringCRUDProject.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
