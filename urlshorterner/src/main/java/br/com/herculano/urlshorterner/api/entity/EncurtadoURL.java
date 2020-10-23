package br.com.herculano.urlshorterner.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "url")
	private String url;
}
