package iot.demo_iot.service;

import iot.demo_iot.model.InfrastructurePhysique;

import java.util.List;
import java.util.Optional;

public interface InfrastructurePhysiqueService {
    List<InfrastructurePhysique>getAll();
    InfrastructurePhysique getById(long id) throws Exception;
    InfrastructurePhysique changerStatus(long id , String nouveaustatut) throws Exception;
    InfrastructurePhysique createIP(InfrastructurePhysique infrastructurePhysique);
    InfrastructurePhysique updateIP(InfrastructurePhysique infrastructurePhysique);
    void deleteIP(long id);

}
