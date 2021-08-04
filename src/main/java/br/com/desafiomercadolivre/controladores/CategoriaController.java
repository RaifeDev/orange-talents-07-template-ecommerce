package br.com.desafiomercadolivre.controladores;

import br.com.desafiomercadolivre.modelos.Categoria;
import br.com.desafiomercadolivre.modelos.formularios.CategoriaRequest;
import br.com.desafiomercadolivre.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @PostMapping
    public ResponseEntity salvarCategoria(@RequestBody @Valid CategoriaRequest formulario){
        Categoria categoria = formulario.converterParaCategoria(categoriaRepository);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }



}
