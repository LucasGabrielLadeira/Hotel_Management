package hotel.management.service.impl;

import hotel.management.entity.Hospede;
import hotel.management.entity.Reserva;
import hotel.management.entity.form.HospedeForm;
import hotel.management.entity.form.HospedeUpdateForm;
import hotel.management.repository.HospedeRepository;
import hotel.management.repository.ReservaRepository;
import hotel.management.service.IHospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeServiceImpl implements IHospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private ReservaRepository reservaRepository;
    @Override
    public Hospede create(HospedeForm form) {
        Hospede hospede = new Hospede();
        hospede.setCpf(form.getCpf());
        hospede.setNome(form.getNome());
        hospede.setEndereco(form.getEndereco());
        hospede.setTelefone(form.getTelefone());
        return hospedeRepository.save(hospede);
    }

    @Override
    public Hospede get(String cpf) {
        Optional<Hospede> hospedeResponse = hospedeRepository.findById(cpf);
        return hospedeResponse.get();
    }

    @Override
    public List<Hospede> getAll() {
        return hospedeRepository.findAll();
    }

    @Override
    public Hospede update(String cpf, HospedeUpdateForm formUpdate) {
        Optional<Hospede> hospedeResponse = hospedeRepository.findById(cpf);
        Hospede hospede = hospedeResponse.get();
        hospede.setEndereco(formUpdate.getEndereco());
        hospede.setTelefone(formUpdate.getTelefone());
        return hospedeRepository.save(hospede);
    }

    @Override
    public void delete(String cpf) {
        Optional<Hospede> hospedeResponse = hospedeRepository.findById(cpf);
        Hospede hospede = hospedeResponse.get();
        hospedeRepository.delete(hospede);
    }

    @Override
    public List<Reserva> getAllReservaCpf(String cpf) {
        Hospede responsavel = hospedeRepository.findById(cpf).get();
        return reservaRepository.findByResponsavel(responsavel);
    }
}
