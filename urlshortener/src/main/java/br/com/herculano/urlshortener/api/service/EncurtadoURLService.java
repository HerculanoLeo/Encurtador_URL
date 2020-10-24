package br.com.herculano.urlshortener.api.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.herculano.urlshortener.api.configuration.system_message.CommonMessage;
import br.com.herculano.urlshortener.api.configuration.system_message.MessageTemplate;
import br.com.herculano.urlshortener.api.constant.StatusEnum;
import br.com.herculano.urlshortener.api.entity.EncurtadoURL;
import br.com.herculano.urlshortener.api.respository.jpa_respository.EncurtadorURLRepository;

@Service
public class EncurtadoURLService extends ServiceTemplate<EncurtadoURL, EncurtadorURLRepository, CommonMessage> {

	private final static String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopkrstuvwxyz";

	@Autowired
	public EncurtadoURLService(EncurtadorURLRepository repository, CommonMessage message) {
		super(repository, message);
	}

	public EncurtadoURL cadastrar(String url) {

		String code = geraCode();

		LocalDateTime dataCriacao = LocalDateTime.now();
		
		EncurtadoURL entity = new EncurtadoURL(null, code, url, dataCriacao, null, StatusEnum.ATIVO.getCodigo());

		getRepository().save(entity);

		return entity;
	}

	public EncurtadoURL buscaPorCode(String code) {

		Optional<EncurtadoURL> optional = getRepository().findByCode(code);

		if (!optional.isPresent()) {
			Object[] args = {code};
			
			throw new EntityNotFoundException(CommonMessage.getCodigo(message.getNotFound(), args));
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
