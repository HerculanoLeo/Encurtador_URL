package br.com.herculano.urlshorterner.api.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncurtadorURLResponse {

	private String urlEncurtada;
	
}
