package com.jairo.cursoskroton.recursos;

import com.jairo.cursoskroton.entidades.Usuario;
import com.jairo.cursoskroton.repository.UsuarioRepository;
import com.jairo.cursoskroton.servicos.UsuarioService;
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
import java.util.Optional;

@RestController
@Api
@RequestMapping("/usuario")
public class UsuarioResource {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    @ApiOperation(value = "Buscar Usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Busca de Usuário"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    ResponseEntity<?> exbirUsuarios() {
            List<Usuario> usuarios = usuarioService.listaUsuarios();

            if (usuarios.size() > 0){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarios);

            } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuarios);
            }

    }
    @PostMapping()
    ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            usuarioService.salvaUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    @GetMapping("/{id}")
    ResponseEntity<?> listaUsuarioPorId(@Valid @PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.listaUsuarioPorId(id);
        try {
            if (usuario.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(usuario);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }




}
