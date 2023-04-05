package hotel.management.service;

import hotel.management.entity.Quarto;
import hotel.management.entity.Reserva;
import hotel.management.entity.form.DisponibilidadeForm;
import hotel.management.entity.form.QuartoForm;
import hotel.management.entity.form.QuartoUpdateForm;

import java.time.LocalDateTime;
import java.util.List;

public interface IQuartoService {
    Quarto create (QuartoForm form);
    Quarto update (Integer numero, QuartoUpdateForm form);
    Quarto get(Integer numero);

    List<Quarto> getAll();

    List<Quarto> getAllDisponivelData(DisponibilidadeForm form);

    void delete(Integer numero);

    List<Reserva> getAllReservaQuarto(Integer numero);
}
