package dev.gui.supermarket.controller;

import ch.qos.logback.core.net.server.Client;
import dev.gui.supermarket.DTOs.ClientDTO;
import dev.gui.supermarket.service.ClientService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService clientService) {
        this.service = clientService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ClientDTO>> listAllClients(){
        List<ClientDTO> clients = service.listAllClients();
        return ResponseEntity.ok(clients);
    }

    @PostMapping("/create")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO){
        ClientDTO client = service.createClient(clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @GetMapping("/list/{id}")
   public ResponseEntity<?> findClient(@PathVariable Long id){
        ClientDTO client = service.findClient(id);
        if(client != null) {
            return ResponseEntity.status(HttpStatus.OK).body(client);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O cliente com o ID (" + id + ") não foi encontrado");
    }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<?> removeClient(@PathVariable Long id){
        ClientDTO client = service.findClient(id);
        if(client != null){
            return ResponseEntity.status(HttpStatus.OK).body(service.removeClient(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O cliente com o ID (" + id + ") não foi encontrado");
   }

   @PutMapping("/edit/{id}")
    public ResponseEntity<?> editClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO){
       ClientDTO client = service.findClient(id);
       if(client != null){
           return ResponseEntity.status(HttpStatus.OK).body(client);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O cliente com o ID (" + id + ") não foi encontrado");
   }
}
