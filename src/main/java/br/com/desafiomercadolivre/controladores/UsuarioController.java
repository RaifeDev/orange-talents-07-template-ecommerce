package br.com.desafiomercadolivre.controladores;

import br.com.desafiomercadolivre.modelos.Usuario;
import br.com.desafiomercadolivre.modelos.formularios.UsuarioRequest;
import br.com.desafiomercadolivre.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity salvarUsuario(@RequestBody @Valid UsuarioRequest formulario){
        Usuario usuario = formulario.converterParaUsuario();
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }




}
