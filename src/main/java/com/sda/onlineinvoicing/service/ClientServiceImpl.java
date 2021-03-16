package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Client;
import com.sda.onlineinvoicing.entity.User;
import com.sda.onlineinvoicing.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients(User user) {
        return clientRepository.findByUser(user);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(int clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public Client getClientById(int clientId) {
        return clientRepository.findById(clientId).orElse(new Client());
    }
}
