package br.com.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springmvc.domain.TipoSexo;
import br.com.springmvc.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Usuario usuario) {
		// entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		// entityManager.getTransaction().commit();
		// entityManager.close();

	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Usuario usuario) {
		entityManager.merge(usuario);

	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		entityManager.remove(entityManager.getReference(Usuario.class, id));

	}

	@Transactional(readOnly = true)
	@Override
	public Usuario getById(Long id) {
		String jpql = "from Usuario u where u.id = :id";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		query.setParameter("id", id);
		return query.getSingleResult();

	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> getTodos() {
		String jpql = "from Usuario u";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

	@Transactional(readOnly = true)
	    @Override
	    public List<Usuario> getBySexo(TipoSexo sexo) {
	        String jpql = "from Usuario u where u.sexo = :sexo";
	        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
	        query.setParameter("sexo", sexo);
	        return query.getResultList();
	}
	
	@Transactional(readOnly = true)
    @Override
    public List<Usuario> getByNome(String nome) {
        String jpql = "from Usuario u where u.nome like :nome or u.sobrenome like :sobrenome";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("nome", "%"+nome+"%");
        query.setParameter("sobrenome", "%"+nome+"%");
        return query.getResultList();
    }

}
