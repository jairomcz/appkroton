package com.jairo.cursoskroton.recursos;

import com.jairo.cursoskroton.entidades.Usuario;
import com.jairo.cursoskroton.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api
@RequestMapping("/usuario")
public class UsuarioResource {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    ResponseEntity<?> cadastrarPerfil() {

        List<Usuario> usuario = usuarioRepository.findAll();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuario);
    }


}
