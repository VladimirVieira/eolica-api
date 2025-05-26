package br.com.ufrn.pds1.projetopds1.model;

import br.com.ufrn.pds1.projetopds1.DTO.PartDTO;
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
@Table(name = "Peças")
public class PartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "Nome da peça")
    String name;

    @Column(name = "Fabricante")
    String manufacturer;

    @Column(name = "Id do aerogerador")
    Long turbineId;

    @Column(name = "Código da estação")
    Long stationId;

    @Column(name = "Descrição adicional")
    String description;


    public PartEntity(PartDTO partDTO) {
        this.name = partDTO.getName();
        this.manufacturer = partDTO.getManufacturer();
        this.turbineId = partDTO.getTurbineId();
        this.stationId = partDTO.getStationId();
        this.description = partDTO.getDescription();
    }


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public Long getTurbineId() {
		return turbineId;
	}


	public void setTurbineId(Long turbineId) {
		this.turbineId = turbineId;
	}


	public Long getStationId() {
		return stationId;
	}


	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
