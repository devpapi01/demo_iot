package iot.demo_iot.service.impl;

import iot.demo_iot.model.Commande;
import iot.demo_iot.model.InfrastructurePhysique;
import iot.demo_iot.repository.CommandeRepository;
import iot.demo_iot.repository.InfrastructureRepository;
import iot.demo_iot.service.InfrastructurePhysiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class InfrastructurePhysiqueServiceImpl implements InfrastructurePhysiqueService {
    @Autowired
    private InfrastructureRepository infrastructureRepository;
    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public List<InfrastructurePhysique> getAll() {
        return infrastructureRepository.findAll();
    }

    @Override
    public InfrastructurePhysique getById(long id) throws Exception {
        Optional<InfrastructurePhysique> infrastructurePhysique = infrastructureRepository.findById(id);
        if (infrastructurePhysique.isEmpty()) {
            throw new Exception("L'infrastructure n'existe pas");
        }
        return infrastructureRepository.findById(id).get();
    }

    @Override
    public InfrastructurePhysique changerStatus(long id, String nouveaustatut) throws Exception {
        InfrastructurePhysique infrastructurePhysique = getById(id);
        if (infrastructurePhysique == null) {
            throw new Exception("L'infrastructure n'existe pas");
        }

        if (infrastructurePhysique.getStatusActuel().equals(nouveaustatut)) {
            return infrastructurePhysique;
        }


        infrastructurePhysique.setStatusActuel(nouveaustatut);

        Commande commande = new Commande();
        LocalDate date = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        commande.setIdComposant(id);
        commande.setDate(sqlDate);
        commande.setActionEffectue(nouveaustatut);
        commandeRepository.save(commande);

        infrastructureRepository.save(infrastructurePhysique);

        return infrastructurePhysique;

    }

    @Override
    public InfrastructurePhysique createIP(InfrastructurePhysique infrastructurePhysique) {
        LocalDate date = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        infrastructurePhysique.setDateAjout(sqlDate);
        InfrastructurePhysique save = infrastructureRepository.save(infrastructurePhysique);

        Commande commande = new Commande();
        commande.setIdComposant(save.getId());
        commande.setDate(sqlDate);
        commande.setActionEffectue("Ajout");
        commandeRepository.save(commande);
        return save;
    }

    @Override
    public InfrastructurePhysique updateIP(InfrastructurePhysique infrastructurePhysique) {
        return infrastructureRepository.save(infrastructurePhysique);
    }

    @Override
    public void deleteIP(long id) {

        if (infrastructureRepository.findById(id).isPresent()) {
            LocalDate date = LocalDate.now();
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            Commande commande = new Commande();
            commande.setIdComposant(id);
            commande.setDate(sqlDate);
            commande.setActionEffectue("Suppression");
            commandeRepository.save(commande);
            infrastructureRepository.deleteById(id);
        }


    }
}
