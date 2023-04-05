package hotel.management.service;

import hotel.management.entity.Hospede;
import hotel.management.entity.Reserva;
import hotel.management.entity.form.HospedeForm;
import hotel.management.entity.form.HospedeUpdateForm;

import java.util.List;
import java.util.Optional;

public interface IHospedeService {
    Hospede create (HospedeForm form);

    Hospede get(String cpf);

    List<Hospede> getAll();

    Hospede update(String cpf, HospedeUpdateForm formUpdate);

    void delete(String cpf);

    List<Reserva> getAllReservaCpf(String cpf);

}
