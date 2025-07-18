package br.com.ufrn.pds1.projetopds1.repository;

import br.com.ufrn.pds1.projetopds1.model.PartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<PartEntity, Long> {

}
