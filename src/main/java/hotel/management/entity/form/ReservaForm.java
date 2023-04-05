package hotel.management.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaForm {

    private String cpfResponsavel;
    private Integer quartoNumero;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
}
