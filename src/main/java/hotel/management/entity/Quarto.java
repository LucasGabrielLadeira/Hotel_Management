package hotel.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_quarto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quarto {
    @Id
    @Column(unique = true)
    private Integer numero;

    //Quantidade de pessoas que podem ser acomodadas no quarto
    private Integer capacidade;

    private Double valor;
}
