package hotel.management.service.impl;

import hotel.management.entity.Quarto;
import hotel.management.entity.Reserva;
import hotel.management.entity.form.DisponibilidadeForm;
import hotel.management.entity.form.QuartoForm;
import hotel.management.entity.form.QuartoUpdateForm;
import hotel.management.repository.QuartoRepository;
import hotel.management.repository.ReservaRepository;
import hotel.management.service.IQuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuartoServiceImpl implements IQuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public Quarto create(QuartoForm form) {
        Quarto quarto = new Quarto();
        quarto.setCapacidade(form.getCapacidade());
        quarto.setNumero(form.getNumero());
        quarto.setValor(form.getValor());
        return quartoRepository.save(quarto);
    }

    @Override
    public Quarto update(Integer numero, QuartoUpdateForm form) {
        Quarto quarto = quartoRepository.findById(numero).get();
        quarto.setValor(form.getValor());
        return quartoRepository.save(quarto);
    }

    @Override
    public Quarto get(Integer numero) {
        return quartoRepository.findById(numero).get();
    }

    @Override
    public List<Quarto> getAll() {
        return quartoRepository.findAll();
    }

    @Override
    public List<Quarto> getAllDisponivelData(DisponibilidadeForm form) {
        LocalDateTime dataEntrada = form.getDataEntrada().atStartOfDay();
        LocalDateTime dataSaida = form.getDataSaida().atStartOfDay();
        List<Quarto> quartosDisponiveis = quartoRepository.findAll();
        List<Quarto> quartos = quartoRepository.findAll();
        quartos.forEach(quarto -> {
            List<Reserva> reservasQuarto = reservaRepository.findByQuarto(quarto);
            reservasQuarto.forEach(reserva -> {
                if((reserva.getDataEntrada().compareTo(dataEntrada) * dataEntrada.compareTo(reserva.getDataSaida()) >= 0) ||
                        (reserva.getDataEntrada().compareTo(dataSaida) * dataSaida.compareTo(reserva.getDataSaida()) >= 0)){
                    quartosDisponiveis.remove(quarto);
                }
            });
        });
        return quartosDisponiveis;
    }

    @Override
    public void delete(Integer numero){
        quartoRepository.deleteById(numero);
    }

    @Override
    public List<Reserva> getAllReservaQuarto(Integer numero) {
        Quarto quarto = quartoRepository.findById(numero).get();
        return reservaRepository.findByQuarto(quarto);
    }
}
