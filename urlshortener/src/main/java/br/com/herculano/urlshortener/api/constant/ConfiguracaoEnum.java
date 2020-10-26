package br.com.herculano.urlshortener.api.constant;

public enum ConfiguracaoEnum {
	
	DOMINIO("encurtador.url.dominio");

	private String codigo;
	
	ConfiguracaoEnum(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
}
