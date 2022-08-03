package com.nttdata.clientservice.model.repository;

import com.nttdata.clientservice.model.document.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Class for ClientRepository.
 */
@Repository
public interface ClientRepository extends
    ReactiveMongoRepository<Client, String> {

}
