package com.test.terpel.app.test_terpel.Repository;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.test.terpel.app.test_terpel.Model.Client;

@Repository
public class ClientRepository implements IClientRepository {

    private static final String FILE_PATH = "src/main/resources/json/Client.json";
    private ObjectMapper objMapper;

        public ClientRepository() {
        objMapper = new ObjectMapper();
        objMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public Client save(Client client) throws IOException {
        List<Client> clients = findAll();
        clients.add(client);
        objMapper.writeValue(new File(FILE_PATH), clients);
        return client;
    }

    @Override
    public List<Client> findAll() throws IOException {
        File file = new File(FILE_PATH);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
    }
        return objMapper.readValue(new File(FILE_PATH), new TypeReference<List<Client>>(){});
    }
    
}
