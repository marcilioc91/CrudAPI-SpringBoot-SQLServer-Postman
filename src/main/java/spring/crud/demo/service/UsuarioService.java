package spring.crud.demo.service;

import org.springframework.stereotype.Service;
import spring.crud.demo.entity.Usuario;
import spring.crud.demo.repository.UsuarioRepository;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}