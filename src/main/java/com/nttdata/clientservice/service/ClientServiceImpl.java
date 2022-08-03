package com.nttdata.clientservice.service;

import com.nttdata.clientservice.model.document.Client;
import com.nttdata.clientservice.model.repository.ClientRepository;
import com.nttdata.clientservice.model.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class for ClientServiceImpl.
 */
@Service
public class ClientServiceImpl implements ClientService {
  @Autowired
  private ClientRepository accountRepository;

  @Override
  public Flux<Client> getAll() {
    return this.accountRepository.findAll();
  }

  @Override
  public Mono<Client> save(Client client) {
    return this.accountRepository.save(client);
  }

  @Override
  public Mono<Client> findById(String id) {
    return this.accountRepository.findById(id);
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return this.accountRepository.existsById(id);
  }

  @Override
  public Mono<Client> update(Client client) {
    return this.accountRepository.save(client);
  }

  @Override
  public void delete(String id) {
    this.accountRepository.deleteById(id);
  }
}
