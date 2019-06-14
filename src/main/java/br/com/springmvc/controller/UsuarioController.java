package br.com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.springmvc.dao.UsuarioDao;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	public UsuarioDao dao;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listar(ModelMap model) {
		model.addAttribute("usuarios", dao.getTodos());
		return new ModelAndView("/user/list", model);

	}

}
