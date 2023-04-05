package hotel.management.service.impl;

import hotel.management.entity.Hospede;
import hotel.management.entity.Reserva;
import hotel.management.entity.form.ReservaAddHospedeForm;
import hotel.management.entity.form.ReservaForm;
import hotel.management.repository.HospedeRepository;
import hotel.management.repository.QuartoRepository;
import hotel.management.repository.ReservaRepository;
import hotel.management.service.IReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Override
    public Reserva create(ReservaForm form) {
        Reserva reserva = new Reserva();
        reserva.setQuarto(quartoRepository.findById(form.getQuartoNumero()).get());
        reserva.setDataEntrada(form.getDataEntrada().atStartOfDay());
        reserva.setDataSaida(form.getDataSaida().atStartOfDay());
        reserva.setResponsavel(hospedeRepository.findById(form.getCpfResponsavel()).get());
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva get(Long id) {
        return reservaRepository.findById(id).get();
    }

    @Override
    public List<Reserva> getAll() {
        return reservaRepository.findAll();
    }

    @Override
    public ResponseEntity addHospede(ReservaAddHospedeForm form) {
        Reserva reserva = reservaRepository.findById(form.getReservaId()).get();
        Hospede hospede = hospedeRepository.findById(form.getHospedeCpf()).get();
        Integer qtdHospedes = reserva.getHospedes().size();
        Integer tamanhoQuarto = reserva.getQuarto().getCapacidade();
        if(tamanhoQuarto > (qtdHospedes + 1)){
            if(reserva.getHospedes().contains(hospede)){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Hospede já está incluso na reserva");
            }else{
                reserva.getHospedes().add(hospede);
                reservaRepository.save(reserva);
                return ResponseEntity.status(HttpStatus.CREATED).body("Reserva feita");
            }
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Capacidade do quarto chegou ao limite");
        }
    }

    @Override
    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public void checkin(Long id) {
        Reserva reserva = reservaRepository.findById(id).get();
        reserva.setCheckin(LocalDateTime.now());

    }

    @Override
    public void checkout(Long id) {
        Reserva reserva = reservaRepository.findById(id).get();
        reserva.setCheckout(LocalDateTime.now());
    }
}
