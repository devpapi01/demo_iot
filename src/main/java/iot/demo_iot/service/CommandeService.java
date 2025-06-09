package iot.demo_iot.service;

import iot.demo_iot.model.Commande;

import java.util.List;

public interface CommandeService {
    List<Commande> getAll();
    Commande getById(Long id);
    Commande create(Commande commande);
    void delete(Long id);


}
