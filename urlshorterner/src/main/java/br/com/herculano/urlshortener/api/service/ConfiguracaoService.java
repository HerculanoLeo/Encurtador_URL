package br.com.herculano.urlshortener.api.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.herculano.urlshortener.api.configuration.system_message.CommonMessage;
import br.com.herculano.urlshortener.api.constant.ConfiguracaoEnum;
import br.com.herculano.urlshortener.api.entity.Configuracao;
import br.com.herculano.urlshortener.api.respository.jpa_respository.ConfiguracaoRepository;

@Service
public class ConfiguracaoService extends ServiceTemplate<Configuracao, ConfiguracaoRepository, CommonMessage>{

	@Autowired
	public ConfiguracaoService(ConfiguracaoRepository repository, CommonMessage message) {
		super(repository, message);
	}

	public String getValorPorCodigo(ConfiguracaoEnum configuracaoEnum) {
		Optional<Configuracao> optional = getRepository().findById(configuracaoEnum.getCodigo());		
		
		if (!optional.isPresent()) {
			Object[] args = {configuracaoEnum.getCodigo()};
			
			throw new EntityNotFoundException(CommonMessage.getCodigo(message.getNotFound(), args));
		}
		
		return optional.get().getValor();
	}
	
}
