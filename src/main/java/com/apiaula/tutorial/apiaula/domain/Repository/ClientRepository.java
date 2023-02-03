package com.apiaula.tutorial.apiaula.domain.Repository;

import com.apiaula.tutorial.apiaula.domain.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

   List<Client> findByName(String name);
   List<Client> findByNameContaining(String name);
   Optional<Client> findByEmail(String email);

}
