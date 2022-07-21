package com.nttdata.clientservice.api;


import com.nttdata.clientservice.model.document.Client;
import com.nttdata.clientservice.model.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Get list of clients
     * @param client
     * @return
     */
    @GetMapping
    public Flux<Client> findAll(@RequestBody Client client) {
        Flux<Client> response = clientService.getAll();
        log.info("findAll");
        log.debug(response.toString());
        return response;
    }

    /**
     * Create client
     * @param client
     * @return
     */
    @PostMapping
    public Mono<Client> create(@RequestBody Client client) {
        Mono<Client> response = clientService.save(client);
        log.info("create OK");
        log.debug(response.toString());
        return response;
    }

    /**
     * Update client
     * @param client
     */
    @PutMapping
    public void update(@RequestBody Client client) {
        clientService.update(client);
        log.info("update OK");
        log.debug(client.getId() + "/" + client.toString());
    }

    /**
     * Delete client by id
     * @param id
     */
    @DeleteMapping({"{id}"})
    public void delete(@PathVariable("id") String id) {
        clientService.delete(id);
        log.info("delete OK");
        log.debug(id.toString());
    }

}
