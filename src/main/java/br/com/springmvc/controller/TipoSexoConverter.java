package br.com.springmvc.controller;


import org.springframework.core.convert.converter.Converter;

import br.com.springmvc.domain.TipoSexo;

public class TipoSexoConverter implements Converter<String,TipoSexo>{

	@Override
	public TipoSexo convert(String source) {
		char tipoSexo  = source.charAt(0);
		return tipoSexo==TipoSexo.FEMININO.getDesc()?TipoSexo.FEMININO:TipoSexo.MASCULINO;
	}

}
