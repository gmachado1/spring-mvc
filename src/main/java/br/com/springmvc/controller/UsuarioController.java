package br.com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springmvc.dao.UsuarioDao;
import br.com.springmvc.domain.Usuario;

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

	@GetMapping("cadastro")
	public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model) {
		return "/user/add";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("usuario")Usuario usuario, RedirectAttributes attValue) {
		dao.salvar(usuario);
		attValue.addFlashAttribute("mensagem", "Salvo com sucesso. ");
		return "redirect:/usuario/todos";
	}

}
