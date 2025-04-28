package br.com.ufrn.pds1.projetopds1.DTO;

import br.com.ufrn.pds1.projetopds1.model.PartEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliationDTO {
    String apraiser;

    String avaliation;

    Long partId;
}
