package br.com.ufrn.pds1.projetopds1.service;

import br.com.ufrn.pds1.projetopds1.DTO.PartDTO;
import br.com.ufrn.pds1.projetopds1.model.PartEntity;
import br.com.ufrn.pds1.projetopds1.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {
    @Autowired
    private PartRepository partRepository;

    //Metodo para salvar peça no banco de dados
    public PartEntity postPart(PartDTO partDTO) {
        PartEntity partEntity = new PartEntity(partDTO);
        return partRepository.save(partEntity);
    }

    //Metodo update para atualizar informaçoes de uma peça pelo ID
    public PartEntity putPart(long id, PartDTO partUpdated) {
        Optional<PartEntity> part = partRepository.findById(id);
        if (part.isPresent()) {
            PartEntity partEntity = part.get();
            if (partUpdated.getName() != null) {
                partEntity.setName(partUpdated.getName());
            }
            if (partUpdated.getManufacturer() != null) {
                partEntity.setManufacturer(partUpdated.getManufacturer());
            }
            if (partUpdated.getDescription() != null) {
                partEntity.setDescription(partUpdated.getDescription());
            }
            if (partUpdated.getStationId() != null){
                partEntity.setStationId(partUpdated.getStationId());
            }
            if (partUpdated.getTurbineId() != null){
                partEntity.setTurbineId(partUpdated.getTurbineId());
            }
            return partRepository.save(partEntity);
        } else {
            throw new RuntimeException("Part not found");
        }
    }

    //Metodo para obter todas as peças cadastradas no banco
    public List<PartEntity> getAllParts() {
        return partRepository.findAll();
    }

    //Metodo para obter peça pelo id
    public PartEntity getPartById(long id) {
        Optional<PartEntity> part = partRepository.findById(id);
        return part.orElseThrow(() -> new RuntimeException("Part not found"));
    }

    //Metodo para deletar peça pelo ID
    public PartEntity deletePart(long id) {
        Optional<PartEntity> part = partRepository.findById(id);
        PartEntity partEntity = part.orElseThrow(() -> new RuntimeException("Part not found"));
        partRepository.delete(partEntity);
        return partEntity;
    }

}
