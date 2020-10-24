package br.com.herculano.urlshortener.api.respository.jpa_respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.herculano.urlshortener.api.entity.Configuracao;

@Repository
public interface ConfiguracaoRepository extends JpaRepository<Configuracao, String> {
	
}
