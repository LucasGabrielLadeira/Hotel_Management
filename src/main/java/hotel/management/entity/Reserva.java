package hotel.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_reserva")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospede_id")
    private Hospede responsavel;

    @ManyToOne
    @JoinColumn(name="quarto_id")
    private Quarto quarto;

    private LocalDateTime dataEntrada;

    private LocalDateTime dataSaida;

    @ManyToMany
    @JoinColumn(name="hospede_id")
    private List<Hospede> hospedes = new ArrayList<>();

    private LocalDateTime checkin;

    private LocalDateTime checkout;
}
