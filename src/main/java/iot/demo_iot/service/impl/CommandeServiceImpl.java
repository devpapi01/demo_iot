package iot.demo_iot.service.impl;


import iot.demo_iot.model.Commande;
import iot.demo_iot.repository.CommandeRepository;
import iot.demo_iot.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    CommandeRepository commandeRepository;


    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getById(Long id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public Commande create(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void delete(Long id) {
    commandeRepository.deleteById(id);
    }
}
