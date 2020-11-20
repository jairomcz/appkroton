package com.jairo.cursoskroton.servicos;

import com.jairo.cursoskroton.entidades.Usuario;
import com.jairo.cursoskroton.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void salvaUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    public List<Usuario> listaUsuarios(){
        List<Usuario> usuario = usuarioRepository.findAll();
        return usuario;
    }

    public Optional<Usuario> listaUsuarioPorId(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario;
    }
}


