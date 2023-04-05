package hotel.management.repository;

import hotel.management.entity.Hospede;
import hotel.management.entity.Quarto;
import hotel.management.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByResponsavel(Hospede responsavel);
    List<Reserva> findByQuarto(Quarto quarto);
}
