package br.com.ufrn.pds1.projetopds1.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartDTO {

    String name;

    String manufacturer;

    Long turbineId;

    Long stationId;

    String description;
}
