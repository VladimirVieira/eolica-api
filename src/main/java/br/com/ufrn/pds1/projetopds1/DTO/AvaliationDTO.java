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

	public String getApraiser() {
		return apraiser;
	}

	public void setApraiser(String apraiser) {
		this.apraiser = apraiser;
	}

	public String getAvaliation() {
		return avaliation;
	}

	public void setAvaliation(String avaliation) {
		this.avaliation = avaliation;
	}

	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
	}
    
    
}
