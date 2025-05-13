package br.com.ufrn.pds.projetopds.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Documentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "Nome do Arquivo")
    String name;

    @Column(name = "Caminho do arquivo")
    String path;
}
