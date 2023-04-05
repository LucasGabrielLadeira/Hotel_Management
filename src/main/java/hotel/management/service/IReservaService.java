package hotel.management.service;

import hotel.management.entity.Quarto;
import hotel.management.entity.Reserva;
import hotel.management.entity.Hospede;
import hotel.management.entity.form.ReservaAddHospedeForm;
import hotel.management.entity.form.ReservaForm;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IReservaService {

    Reserva create (ReservaForm form);

    Reserva get(Long id);

    List<Reserva> getAll();

    ResponseEntity addHospede(ReservaAddHospedeForm form);

    void delete(Long id);

    void checkin(Long id);

    void checkout(Long id);
}
