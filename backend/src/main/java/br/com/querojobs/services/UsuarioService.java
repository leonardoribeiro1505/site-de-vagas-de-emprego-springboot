package br.com.querojobs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.querojobs.models.auth.Usuario;
import br.com.querojobs.repositories.UsuarioRepository;
import br.com.querojobs.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private BCryptPasswordEncoder bCryp;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario find(String id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario usuario) {
		usuario.setId(null);
		usuario.setSenha(bCryp.encode(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}
	
	public Usuario update(Usuario usuario) {
			find(usuario.getId());
			this.usuarioRepository.save(usuario);
		return usuario;
	}
	
	public void delete(String id) {
		find(id);
		this.usuarioRepository.deleteById(id);
	}
	
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}

}
