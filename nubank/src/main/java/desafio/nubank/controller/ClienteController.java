package desafio.nubank.controller;

import desafio.nubank.DTO.ClienteDTO;
import desafio.nubank.DTO.RespostaClienteDTO;
import desafio.nubank.DTO.RespostaContatoDTO;
import desafio.nubank.model.Cliente;
import desafio.nubank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody ClienteDTO cliente){
        Cliente clienteSalvo = clienteService.salvarCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<RespostaClienteDTO>> listarClientes(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<RespostaContatoDTO>> listarContatos(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.listarPorId(id));
    }

}
