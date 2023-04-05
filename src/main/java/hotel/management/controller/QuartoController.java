package hotel.management.controller;

import hotel.management.entity.Quarto;
import hotel.management.entity.Reserva;
import hotel.management.entity.form.DisponibilidadeForm;
import hotel.management.entity.form.QuartoForm;
import hotel.management.entity.form.QuartoUpdateForm;
import hotel.management.service.impl.QuartoServiceImpl;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    @Autowired
    private QuartoServiceImpl service;

    @PostMapping
    public Quarto create(@RequestBody QuartoForm form){
        return service.create(form);
    }

    @PostMapping("/update/{numero}")
    public Quarto update(@PathVariable Integer numero, @RequestBody QuartoUpdateForm form){
        return service.update(numero, form);
    }

    @GetMapping("/{numero}")
    public Quarto get(@PathVariable Integer numero){
        return service.get(numero);
    }

    @GetMapping
    public List<Quarto> getAll(){
        return service.getAll();
    }

    @PostMapping("/disponiveldata")
    public List<Quarto> getAllDisponivelData(@RequestBody DisponibilidadeForm form){
        return service.getAllDisponivelData(form);
    }

    @DeleteMapping("/{numero}")
    public void delete(@PathVariable Integer numero){
        service.delete(numero);
    }

    @GetMapping("/reserva/{numero}")
    public List<Reserva> getAllReservaQuarto(@PathVariable Integer numero){
        return service.getAllReservaQuarto(numero);
    }
}
