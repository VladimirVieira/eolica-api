package br.com.ufrn.pds1.projetopds1.service;

import br.com.ufrn.pds1.projetopds1.DTO.AvaliationDTO;
import br.com.ufrn.pds1.projetopds1.model.AvaliationEntity;
import br.com.ufrn.pds1.projetopds1.model.PartEntity;
import br.com.ufrn.pds1.projetopds1.repository.AvaliationRepository;
import br.com.ufrn.pds1.projetopds1.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliationService {
    @Autowired
    private AvaliationRepository avaliationRepository;

    @Autowired
    private PartRepository partRepository;

    //Metodo de post da avaliação
    public AvaliationEntity postAvaliation(AvaliationDTO avaliationDTO) {
        AvaliationEntity avaliation = new AvaliationEntity(avaliationDTO);
        avaliation.setApraiser(avaliationDTO.getApraiser());
        avaliation.setAvaliation(avaliationDTO.getAvaliation());
        PartEntity partEntity = partRepository.findById(avaliationDTO.getPartId()).orElseThrow(()-> new RuntimeException("Part not found"));
        avaliation.setPartEntity(partEntity);
        return avaliationRepository.save(avaliation);
    }
    //Metodo put da avaliação
    public AvaliationEntity putAvaliation(Long id,AvaliationDTO avaliationATT) {
        Optional<AvaliationEntity> avaliation = avaliationRepository.findById(id);
        if (avaliation.isPresent()) {
            AvaliationEntity avaliationEntity = avaliation.get();
            if (avaliationATT.getApraiser() != null) {
                avaliationEntity.setApraiser(avaliationATT.getApraiser());
            }
            if (avaliationATT.getAvaliation() != null) {
                avaliationEntity.setAvaliation(avaliationATT.getAvaliation());
            }
            if (avaliationATT.getPartId() != null) {
                Optional<PartEntity> part = partRepository.findById(avaliationATT.getPartId());
                part.ifPresent(avaliationEntity::setPartEntity);
            }
            return avaliationRepository.save(avaliationEntity);
        }else{
            throw new RuntimeException("Avaliation not found");
        }

    }

    //Metodo delete avaliação
    public AvaliationEntity deleteAvaliation(Long id) {
        Optional<AvaliationEntity> avaliation = avaliationRepository.findById(id);
        if (avaliation.isPresent()) {
            AvaliationEntity avaliationEntity = avaliation.get();
            avaliationRepository.delete(avaliationEntity);
            return avaliationEntity;
        }else {
            throw new RuntimeException("Avaliation not found");
        }
    }

    //Metodo getAll avaliação
    public List<AvaliationEntity> getAllAvaliation() {
        return avaliationRepository.findAll();
    }

    //Metodo getById
    public AvaliationEntity getAvaliationById(Long id) {
        Optional<AvaliationEntity> avaliation = avaliationRepository.findById(id);
        if (avaliation.isPresent()) {
            return avaliation.get();
        } else {
            throw new RuntimeException("Avaliation not found");
        }
    }
}
