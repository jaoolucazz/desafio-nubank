package desafio.nubank.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RespostaContatoDTO {

    private  Long id;
    private String email;
    private String telefone;
    private Long clienteId;

}
