package com.barroncasadc.demo.parkapi.service;

import com.barroncasadc.demo.parkapi.entity.Usuario;
import com.barroncasadc.demo.parkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service // transforma em um BEAN
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional // Spring que vai gerenciar abrir e fechar conexao com DB
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true) // apenas de leitura não terá modificacao
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado!")
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, String password) {
        Usuario user = buscarPorId(id);
        user.setPassword(password);
        return user;
    }

    @Transactional(readOnly = true) // apenas de leitura não terá modificacao
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
