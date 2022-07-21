package com.nttdata.clientservice.model.service;


import com.nttdata.clientservice.model.document.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Flux<Client> getAll();

    Mono<Client> save(Client client);

    Mono<Client> findById(String id);

    Mono<Boolean> existsById(String id);

    Mono<Client> update(Client client);

    void delete(String id);
}
