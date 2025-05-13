package br.com.ufrn.pds.projetopds.repository;

import br.com.ufrn.pds.projetopds.model.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
}
