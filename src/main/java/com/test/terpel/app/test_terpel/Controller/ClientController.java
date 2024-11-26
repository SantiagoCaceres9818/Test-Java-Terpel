package com.test.terpel.app.test_terpel.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.terpel.app.test_terpel.Model.Client;
import com.test.terpel.app.test_terpel.Service.ClientServices;
import com.test.terpel.app.test_terpel.dto.AverageDto;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    
    @Autowired
    private ClientServices clientServices;

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client client) throws IOException{
        return ResponseEntity.ok(clientServices.saveClient(client));
    }

    @GetMapping("/order-name")
    public ResponseEntity<List<Client>> listClientsAlphabeticallynts () throws IOException {
        return ResponseEntity.ok(clientServices.listClientsAlphabetically());
    }

    @GetMapping("/order-age")
    public ResponseEntity<List<String>> listClientsByAge () throws IOException {
        return ResponseEntity.ok(clientServices.listClientsByAge());
    }

    @GetMapping("/average")
    public ResponseEntity<AverageDto> averageAge() throws IOException {
        AverageDto response = new AverageDto(clientServices.quantityClients(), clientServices.averageAge());
        return ResponseEntity.ok(response);
    }
    

}
