package hotel.management.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_hospede")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Hospede {
    @Id
    @Column(unique = true)
    private String cpf;

    private String nome;

    private String endereco;

    private String telefone;
}
