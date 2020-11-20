package com.jairo.cursoskroton.repository;

import com.jairo.cursoskroton.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Override
    List<Usuario> findAll();
    Usuario findById(long id);
    Usuario save(Usuario usuario);
}
