package desafio.nubank.controller;

import desafio.nubank.DTO.ContatoDTO;
import desafio.nubank.model.Cliente;
import desafio.nubank.model.Contato;
import desafio.nubank.repository.ClienteRepository;
import desafio.nubank.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<?> criarContato(@RequestBody ContatoDTO contatoDto){

        Optional<Cliente> cliente = clienteRepository.findById(contatoDto.getClienteId());
        if (cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erro");
        }

        Contato contato = new Contato();
        contato.setTelefone(contato.getTelefone());
        contato.setClientes(contato.getClientes());
        contato.setEmail(contato.getEmail());
        contatoRepository.save(contato);

        return ResponseEntity.status(HttpStatus.CREATED).body(contato);

    }

}
