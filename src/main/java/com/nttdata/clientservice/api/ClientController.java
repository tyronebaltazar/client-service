package com.nttdata.clientservice.api;


import com.nttdata.clientservice.model.document.Client;
import com.nttdata.clientservice.model.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase controller Client.
 */
@RestController
@RequestMapping("/clients")
@Slf4j
public class ClientController {

  @Autowired
  private ClientService clientService;

  /**
   * Get list of clients.
   *
   * @return clients
   */
  @GetMapping
  public Flux<Client> findAll() {
    Flux<Client> response = clientService.getAll();
    log.info("findAll");
    log.debug(response.toString());
    return response;
  }

  /**
   * Create client.
   *
   * @param client represents Client
   * @return client
   */
  @PostMapping
  public Mono<Client> create(@RequestBody final Client client) {
    Mono<Client> response = clientService.save(client);
    log.info("create OK");
    log.debug(response.toString());
    return response;
  }

  /**
   * Update client.
   *
   * @param client represents Client
   */
  @PutMapping
  public void update(@RequestBody final Client client) {
    clientService.update(client);
    log.info("update OK");
    log.debug(client.getId() + "/" + client.toString());
  }

  /**
   * Delete client by id.
   *
   * @param id represents clientId
   */
  @DeleteMapping({"{id}"})
  public void delete(@PathVariable("id") final String id) {
    clientService.delete(id);
    log.info("delete OK");
    log.debug(id.toString());
  }

}
