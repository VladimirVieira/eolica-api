package br.com.ufrn.pds1.projetopds1.model;

import br.com.ufrn.pds1.projetopds1.DTO.AvaliationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Avaliações")
public class AvaliationEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "Avaliador")
    String apraiser;

    @Column(name = "Avaliação")
    String avaliation;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "part_id")
    private PartEntity partEntity;

    public AvaliationEntity(AvaliationDTO avaliationDTO) {
        this.apraiser = avaliationDTO.getApraiser();
        this.avaliation = avaliationDTO.getAvaliation();

    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public PartEntity getPartEntity() {
		return partEntity;
	}

	public void setPartEntity(PartEntity partEntity) {
		this.partEntity = partEntity;
	}
    
    
}
