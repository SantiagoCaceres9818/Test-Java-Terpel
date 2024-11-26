package com.test.terpel.app.test_terpel.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.terpel.app.test_terpel.Model.Client;
import com.test.terpel.app.test_terpel.Repository.ClientRepository;

@Service
public class ClientServices {
    
    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient (Client client) throws IOException{
        return clientRepository.save(client);
    }

    public List<Client> listClientsAlphabetically () throws IOException {
        return clientRepository.findAll().stream()
            .sorted((client1, client2) -> 
            client1.getName().compareToIgnoreCase(client2.getName())).toList();
    }

    public List<String> listClientsByAge () throws IOException {
        return clientRepository.findAll().stream()
                .sorted((client1, client2) -> calculateAge(client1.getBirthday()) - calculateAge(client2.getBirthday()))
                .map(client -> "Client: " + client.getName() + " Age: " + calculateAge(client.getBirthday()))
                .toList();
    }

    private int calculateAge (LocalDate birthday) {
        return Period.between(birthday, LocalDate.now()).getYears();
    } 

}
