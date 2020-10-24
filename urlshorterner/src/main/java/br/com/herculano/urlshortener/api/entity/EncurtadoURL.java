package br.com.herculano.urlshortener.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_url")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EncurtadoURL {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_url")
	@SequenceGenerator(name = "sq_url", sequenceName = "sq_url", allocationSize = 1)
	private Integer id;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "url", nullable = false)
	private String url;
	
	@Column(name = "dt_criacao", nullable = false)
	private LocalDateTime dataCriacao;
	
	@Column(name = "dt_validade")
	private LocalDateTime dataValidade;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	
	@JsonIgnore
	public String getDeStatus() {
		return this.status;
	}
}
