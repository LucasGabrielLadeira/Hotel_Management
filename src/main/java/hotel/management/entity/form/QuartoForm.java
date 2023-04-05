package hotel.management.entity.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuartoForm {
    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 3, message = "'${validatedValue}' precisar ter {max} caracteres.")
    private Integer numero;

    @NotBlank(message = "Preencha o campo corretamente")
    private Integer capacidade;

    @NotBlank(message = "Preencha o campo corretamente")
    private Double valor;
}
