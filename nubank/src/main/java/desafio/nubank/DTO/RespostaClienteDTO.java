package desafio.nubank.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RespostaClienteDTO {

    private Long id;
    private String nome;
    private List<RespostaContatoDTO> contatos;

}
