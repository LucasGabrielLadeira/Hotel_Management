package hotel.management.controller;

import hotel.management.entity.Reserva;
import hotel.management.entity.form.ReservaAddHospedeForm;
import hotel.management.entity.form.ReservaForm;
import hotel.management.service.impl.ReservaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaServiceImpl service;

    @PostMapping
    public Reserva create(@RequestBody ReservaForm form){
        return service.create(form);
    }

    @GetMapping("/{id}")
    public Reserva get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping
    public List<Reserva> getAll(){
        return service.getAll();
    }

    @PostMapping("/adicionarhospede")
    public void addHospede(@RequestBody ReservaAddHospedeForm form){
        service.addHospede(form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("checkin/{id}")
    public void checkin(@PathVariable Long id){
        service.checkin(id);
    }

    @GetMapping("checkout/{id}")
    public void checkout(@PathVariable Long id){
        service.checkout(id);
    }
}
