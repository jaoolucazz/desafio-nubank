package desafio.nubank.service;

import desafio.nubank.DTO.ClienteDTO;
import desafio.nubank.DTO.RespostaClienteDTO;
import desafio.nubank.DTO.RespostaContatoDTO;
import desafio.nubank.model.Cliente;
import desafio.nubank.model.Contato;
import desafio.nubank.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente salvarCliente(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        if (dto.getContatos() != null && dto.getContatos().size() > 0){
            List<Contato> contatos = dto.getContatos().stream().map(c -> {
                Contato contato = new Contato();
                contato.setTelefone(c.getTelefone());
                contato.setEmail(c.getEmail());
                contato.setClientes(cliente);
                return contato;
            }).collect(Collectors.toList());
            cliente.setContatos(contatos);
        }
        return clienteRepository.save(cliente);
    }

    public List<RespostaClienteDTO> listarClientes(){
        return clienteRepository.findAll().stream().map(this::paraDTO).collect(Collectors.toList());
    }

    public List<RespostaContatoDTO> listarPorId(Long clienteId){
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("erro"));

        return cliente.getContatos().stream().map(c -> {
            RespostaContatoDTO contato = new RespostaContatoDTO();
            contato.setTelefone(c.getTelefone());
            contato.setEmail(c.getEmail());
            contato.setId(contato.getId());
            return contato;
        }).collect(Collectors.toList());
    }

    private RespostaClienteDTO paraDTO(Cliente cliente){
        RespostaClienteDTO dto = new RespostaClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());

        List<RespostaContatoDTO> contatos = cliente.getContatos().stream().map(c -> {
            RespostaContatoDTO contato = new RespostaContatoDTO();
            contato.setTelefone(c.getTelefone());
            contato.setEmail(c.getEmail());
            contato.setId(contato.getId());
            return contato;
        }).collect(Collectors.toList());
        dto.setContatos(contatos);

        return dto;
    }

}
