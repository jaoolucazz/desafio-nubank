package desafio.nubank.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ContatoDTO {

    private String email;
    private String telefone;
    private Long clienteId;
}
