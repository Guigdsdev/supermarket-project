package dev.gui.supermarket.mapper;

import ch.qos.logback.core.net.server.Client;
import dev.gui.supermarket.DTOs.ClientDTO;
import dev.gui.supermarket.model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientModel map(ClientDTO clientDTO){
        ClientModel clientModel = new ClientModel();
        clientModel.setId(clientDTO.getId());
        clientModel.setAddress(clientDTO.getAddress());
        clientModel.setAge(clientDTO.getAge());
        clientModel.setName(clientDTO.getName());
        clientModel.setEmail(clientDTO.getEmail());
        clientModel.setImage(clientDTO.getImage());
        clientModel.setProducts(clientDTO.getProducts());
        return clientModel;
    }

    public ClientDTO map(ClientModel clientModel){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(clientModel.getId());
        clientDTO.setAddress(clientModel.getAddress());
        clientDTO.setAge(clientModel.getAge());
        clientDTO.setName(clientModel.getName());
        clientDTO.setEmail(clientModel.getEmail());
        clientDTO.setImage(clientModel.getImage());
        clientDTO.setProducts(clientModel.getProducts());
        return clientDTO;
    }
}
