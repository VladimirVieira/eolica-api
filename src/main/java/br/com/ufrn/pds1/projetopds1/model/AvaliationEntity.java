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
}
