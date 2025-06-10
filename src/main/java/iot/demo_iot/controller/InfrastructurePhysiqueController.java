package iot.demo_iot.controller;

import iot.demo_iot.model.InfrastructurePhysique;
import iot.demo_iot.service.InfrastructurePhysiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/infrastructure")
public class InfrastructurePhysiqueController {
    @Autowired
    InfrastructurePhysiqueService infrastructurePhysiqueService;

    @GetMapping("/all")
    public List<InfrastructurePhysique> getAll(){
        return  infrastructurePhysiqueService.getAll();
    }

    @GetMapping("/{id}")
    public InfrastructurePhysique getById(@PathVariable("id") Long id) throws Exception {
        if (infrastructurePhysiqueService.getById(id)==null){
            return null;

        }
        return infrastructurePhysiqueService.getById(id);

    }

    @PostMapping("/create")
    public InfrastructurePhysique create(@RequestBody InfrastructurePhysique infrastructurePhysique){
        return  infrastructurePhysiqueService.createIP(infrastructurePhysique);
    }

    @PutMapping("/update")
    public InfrastructurePhysique update (@RequestBody InfrastructurePhysique infrastructurePhysique){
        return  infrastructurePhysiqueService.updateIP(infrastructurePhysique);
    }

    @PutMapping("/status")
    public InfrastructurePhysique changeStatut(@RequestParam("id")Long id, @RequestParam("statut") String statut) throws Exception {
    return infrastructurePhysiqueService.changerStatus(id,statut);
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable("id") Long id){
        infrastructurePhysiqueService.deleteIP(id);
    }

}
