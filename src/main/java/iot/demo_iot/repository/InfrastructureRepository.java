package iot.demo_iot.repository;

import iot.demo_iot.model.InfrastructurePhysique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfrastructureRepository  extends JpaRepository<InfrastructurePhysique, Long> {

}
