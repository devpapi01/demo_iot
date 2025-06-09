package iot.demo_iot.controller;

import iot.demo_iot.model.Commande;
import iot.demo_iot.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    @Autowired
    CommandeService commandeService;


    @GetMapping("/all")
    public List<Commande> getAll(){
        return commandeService.getAll();
    }

    @GetMapping("/{id}")
    public Commande getById(@PathVariable("id") Long id){
        return  commandeService.getById(id);
    }

    @PostMapping("/add")
    public Commande create(@RequestBody Commande commande){
        return  commandeService.create(commande);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        commandeService.delete(id);
    }
}
