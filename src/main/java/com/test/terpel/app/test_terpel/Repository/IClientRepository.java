package com.test.terpel.app.test_terpel.Repository;

import java.io.IOException;
import java.util.List;

import com.test.terpel.app.test_terpel.Model.Client;

public interface IClientRepository {
    
    Client save (Client client) throws IOException;
    List<Client> findAll () throws IOException;
}
