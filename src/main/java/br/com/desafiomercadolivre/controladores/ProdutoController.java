package br.com.desafiomercadolivre.controladores;

import br.com.desafiomercadolivre.modelos.Produto;
import br.com.desafiomercadolivre.modelos.formularios.ProdutoRequest;
import br.com.desafiomercadolivre.repositorios.CategoriaRepository;
import br.com.desafiomercadolivre.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @PostMapping
    public ResponseEntity<?> salvarProduto(@RequestBody @Valid ProdutoRequest formulario){
        System.out.println(formulario.toString());
        Produto produto = formulario.converterParaProduto(categoriaRepository);
        produtoRepository.save(produto);
        return ResponseEntity.ok().build();
    }



}
