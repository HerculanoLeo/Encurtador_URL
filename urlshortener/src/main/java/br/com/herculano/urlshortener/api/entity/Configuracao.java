package br.com.herculano.urlshortener.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name =  "tb_configuracao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Configuracao {

	@Id
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "valor")
	private String valor;
}
