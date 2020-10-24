package br.com.herculano.urlshortener.api.respository.jpa_respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.herculano.urlshortener.api.entity.EncurtadoURL;
import br.com.herculano.urlshortener.api.respository.custom.EncurtadorURLRepositoryCustom;

public interface EncurtadorURLRepository extends JpaRepository<EncurtadoURL, Integer>, EncurtadorURLRepositoryCustom {

	@Query(value = "SELECT count(*) FROM tb_url url", nativeQuery = true)
	public Long maxCount();

	public Optional<EncurtadoURL> findByCode(String code);
}
