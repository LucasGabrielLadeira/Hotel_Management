package hotel.management.controller;

import hotel.management.entity.Hospede;
import hotel.management.entity.Reserva;
import hotel.management.entity.form.HospedeForm;
import hotel.management.entity.form.HospedeUpdateForm;
import hotel.management.service.impl.HospedeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    @Autowired
    private HospedeServiceImpl service;

    @PostMapping
    public Hospede create(@RequestBody HospedeForm form){
        return service.create(form);
    }

    @GetMapping
    public List<Hospede> getAll(){return service.getAll();}

    @GetMapping("find/{cpf}")
    public Hospede get(@PathVariable String cpf){
        return service.get(cpf);
    }

    @PostMapping("/update/{cpf}")
    public Hospede update(@PathVariable String cpf, @RequestBody HospedeUpdateForm form){
        return service.update(cpf, form);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable String cpf){
        service.delete(cpf);
    }

    @GetMapping("/reserva/{cpf}")
    public List<Reserva> getAllReservaCpf(@PathVariable String cpf){
        return service.getAllReservaCpf(cpf);
    }

}
