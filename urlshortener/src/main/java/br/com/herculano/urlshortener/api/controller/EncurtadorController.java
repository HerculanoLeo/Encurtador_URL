package br.com.herculano.urlshortener.api.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.herculano.urlshortener.api.constant.ConfiguracaoEnum;
import br.com.herculano.urlshortener.api.controller.response.EncurtadorURLResponse;
import br.com.herculano.urlshortener.api.entity.EncurtadoURL;
import br.com.herculano.urlshortener.api.service.ConfiguracaoService;
import br.com.herculano.urlshortener.api.service.EncurtadoURLService;

@Controller
@RequestMapping("/")
public class EncurtadorController {
	
	@Autowired
	private EncurtadoURLService service;
	
	@Autowired
	private ConfiguracaoService configuracaoService;

	@GetMapping("/api")
	@ResponseBody
	public ResponseEntity<?> encurtarURL(@RequestParam(required = true, name = "url") String url) {
		
		EncurtadoURL entity = service.cadastrar(url);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new EncurtadorURLResponse(geraURL(entity.getCode())));
	}
	
	
	@GetMapping("{code}")
	public RedirectView redireciona(@PathVariable(name = "code") String code, HttpServletResponse response, RedirectAttributes attributes) {
		EncurtadoURL entity = service.buscaPorCode(code);
		
		attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
		
        return new RedirectView(entity.getUrl());
	}
	
	private String geraURL(String code) {
		String url = configuracaoService.getValorPorCodigo(ConfiguracaoEnum.DOMINIO);
		
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(url);
		builder.pathSegment(code);
		
		String uriString = builder.toUriString();
		return uriString;
	}
}
