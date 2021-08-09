package br.com.desafiomercadolivre.controladores;

import br.com.desafiomercadolivre.modelos.ImagemProduto;
import br.com.desafiomercadolivre.modelos.Produto;
import br.com.desafiomercadolivre.modelos.Usuario;
import br.com.desafiomercadolivre.modelos.formularios.ImagemProdutoRequest;
import br.com.desafiomercadolivre.modelos.formularios.ProdutoRequest;
import br.com.desafiomercadolivre.repositorios.CategoriaRepository;
import br.com.desafiomercadolivre.repositorios.ProdutoRepository;
import br.com.desafiomercadolivre.repositorios.UsuarioRepository;
import br.com.desafiomercadolivre.utils.UploaderSimulador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UploaderSimulador uploaderSimulador;


    @PostMapping
    public ResponseEntity<?> salvarProduto(@RequestBody @Valid ProdutoRequest formulario, @AuthenticationPrincipal Usuario usuario){
        System.out.println("Usuario logado: " + usuario.getUsername());
        Produto produto = formulario.converterParaProduto(categoriaRepository, usuario);
        produtoRepository.save(produto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{idProduto}/imagens")
    @Transactional
    public ResponseEntity<?> cadastrarImagemAoProduto(@PathVariable Long idProduto, @Valid ImagemProdutoRequest formulario,
                                                      @AuthenticationPrincipal Usuario usuario){

        List<String> urls = uploaderSimulador.upload(formulario.getImagens());
        Optional<Produto> possivelProduto = produtoRepository.findById(idProduto);

        if(possivelProduto.isEmpty() || !possivelProduto.get().getUsuarioProprietario().equals(usuario)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Produto produto = possivelProduto.get();
        produto.associaImagens(urls);
        produtoRepository.save(produto);
        return ResponseEntity.ok().build();
    }



}
