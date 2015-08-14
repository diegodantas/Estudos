package br.com.caelum.vraptor.DAO;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.caelum.vraptor.model.Usuario;

public class UsuarioDAO {
	
	@Inject
	private EntityManager entityManager;
	
	private Session session;

	private Criteria criteria;
	
	private Usuario usuario;

	public void cadastrarUsuario(Usuario usuario){
		entityManager.persist(usuario);
	}

	public void deletarUsuario(Integer id){
		usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario){
		entityManager.merge(usuario);
	}

	public Usuario listarUsuario(Integer id){
		return usuario = entityManager.find(Usuario.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodosUsuarios(){
		
		session = entityManager.unwrap(Session.class);
		criteria = this.session.createCriteria(Usuario.class);
		return criteria.addOrder(Order.asc("Id")).list();
		
	}
}