package br.com.herculano.urlshortener.api.constant;

public enum StatusEnum {
	
	ATIVO("ati"),
	INATIVO("itv");
	
	private String codigo;
	
	StatusEnum(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
}
