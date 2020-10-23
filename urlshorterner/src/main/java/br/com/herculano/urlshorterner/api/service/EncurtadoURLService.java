package br.com.herculano.urlshorterner.api.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.herculano.urlshorterner.api.configuration.system_message.CommonMessage;
import br.com.herculano.urlshorterner.api.entity.EncurtadoURL;
import br.com.herculano.urlshorterner.api.respository.jpsRespository.EncurtadorURLRepository;

@Service
public class EncurtadoURLService extends ServiceTemplate<EncurtadoURL, EncurtadorURLRepository, CommonMessage> {

	private final static String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopkrstuvwxyz";

	@Autowired
	public EncurtadoURLService(EncurtadorURLRepository repository, CommonMessage message) {
		super(repository, message);
	}

	public EncurtadoURL cadastrar(String url) {

		String code = geraCode();

		EncurtadoURL entity = new EncurtadoURL(null, code, url);

		getRepository().save(entity);

		return entity;
	}

	public EncurtadoURL buscaPorCode(String code) {

		Optional<EncurtadoURL> optional = getRepository().findByCode(code);

		if (!optional.isPresent()) {
			throw new EntityNotFoundException(message.getNotFound());
		}

		return optional.get();

	}

	private String geraCode() {

		Long count = getRepository().maxCount();

		String code = RandomStringUtils.random(8, ALFABETO + count.toString());

		Optional<EncurtadoURL> optional = getRepository().findByCode(code);

		if (optional.isPresent()) {
			return geraCode();
		}

		return code;
	}

}
