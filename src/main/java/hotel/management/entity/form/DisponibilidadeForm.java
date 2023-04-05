package hotel.management.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisponibilidadeForm {
    private LocalDate dataEntrada;

    private LocalDate dataSaida;
}
