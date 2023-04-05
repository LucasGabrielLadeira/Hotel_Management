package hotel.management.entity.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospedeForm {
    @NotBlank(message = "Preencha o campo corretamente")
    @CPF(message = "'${validatedValue}' é inválido!")
    private String cpf;

    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisar estar entre {min} e {max} caracteres.")
    private String nome;

    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 80, message = "'${validatedValue}' precisar estar entre {min} e {max} caracteres.")
    private String endereco;

    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 20, message = "'${validatedValue}' precisar estar entre {min} e {max} caracteres.")
    private String telefone;
}
