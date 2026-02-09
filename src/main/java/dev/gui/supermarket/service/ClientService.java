package dev.gui.supermarket.service;

import ch.qos.logback.core.net.server.Client;
import dev.gui.supermarket.DTOs.ClientDTO;
import dev.gui.supermarket.mapper.ClientMapper;
import dev.gui.supermarket.model.ClientModel;
import dev.gui.supermarket.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository repository;

    private final ClientMapper mapper;

    public ClientService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ClientDTO> listAllClients(){
        List<ClientModel> client = repository.findAll();
        return client.stream().map(mapper::map).collect(Collectors.toList());
    }

    public ClientDTO createClient(ClientDTO clientDTO){
       ClientModel client = mapper.map(clientDTO);
       repository.save(client);
       return mapper.map(client);
    }

    public ClientDTO editClient(Long id, ClientDTO clientDTO){
        Optional<ClientModel> clientExist = repository.findById(id);
        if(clientExist.isPresent()){
            ClientModel client = mapper.map(clientDTO);
            client.setId(id);
            ClientModel clientSave = repository.save(client);
            return mapper.map(client);
        }
        return null;
    }

    public ClientDTO findClient(Long id){
        Optional<ClientModel> client = repository.findById(id);
        return client.map(mapper::map).orElse(null);
    }

    public ClientDTO removeClient(Long id){
        if(repository.findById(id) != null){
            repository.deleteById(id);
        }
        return null;
    }

}
