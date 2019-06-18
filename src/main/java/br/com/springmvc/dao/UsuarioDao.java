package br.com.springmvc.dao;

import java.util.List;

import br.com.springmvc.domain.TipoSexo;
import br.com.springmvc.domain.Usuario;

public interface UsuarioDao {

	void salvar(Usuario usuario);

	void editar(Usuario usuario);

	void excluir(Long id);

	Usuario getById(Long id);

	List<Usuario> getTodos();

	List<Usuario> getBySexo(TipoSexo sexo);

	List<Usuario> getByNome(String nome);
}
