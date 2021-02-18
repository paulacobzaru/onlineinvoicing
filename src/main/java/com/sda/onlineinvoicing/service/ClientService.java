package com.sda.onlineinvoicing.service;

import com.sda.onlineinvoicing.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    void saveClient(Client client);

    void deleteClient(int clientId);

    Client getClientById(int clientId);
}
