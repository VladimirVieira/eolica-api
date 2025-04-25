package br.com.ufrn.pds1.projetopds1.model;

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
    long turbineId;

    @Column(name = "Código da estação")
    long stationId;

    @Column(name = "Descrição adicional")
    String description;



}
