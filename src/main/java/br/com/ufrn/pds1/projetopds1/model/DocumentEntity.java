package br.com.ufrn.pds1.projetopds1.model;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
    
    
}
