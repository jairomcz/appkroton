package com.jairo.cursoskroton.recursos;

import com.jairo.cursoskroton.entidades.Usuario;
import com.jairo.cursoskroton.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api
@RequestMapping("/usuario")
public class UsuarioResource {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    @ApiOperation(value = "Buscar Usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Busca de Usuário"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    ResponseEntity<?> exbirUsuario() {
        List<Usuario> usuario = usuarioRepository.findAll();


            if (usuario.size() > 0){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuario);

            } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuario);
            }

    }
    @PostMapping
    ResponseEntity<?> cadastrarUsuari(@Valid @RequestBody Usuario usuario) {
        try {
            usuario = usuarioRepository.save(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuario);
        }

    }


}
