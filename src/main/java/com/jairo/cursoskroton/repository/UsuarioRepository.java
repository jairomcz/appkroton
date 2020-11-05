package com.jairo.cursoskroton.repository;

import com.jairo.cursoskroton.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
