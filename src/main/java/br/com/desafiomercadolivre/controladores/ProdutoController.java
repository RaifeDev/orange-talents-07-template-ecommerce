package br.com.desafiomercadolivre.controladores;

import br.com.desafiomercadolivre.modelos.Opiniao;
import br.com.desafiomercadolivre.modelos.Pergunta;
import br.com.desafiomercadolivre.modelos.Produto;
import br.com.desafiomercadolivre.modelos.Usuario;
import br.com.desafiomercadolivre.modelos.formularios.ImagemProdutoRequest;
import br.com.desafiomercadolivre.modelos.formularios.OpiniaoRequest;
import br.com.desafiomercadolivre.modelos.formularios.PerguntaRequest;
import br.com.desafiomercadolivre.modelos.formularios.ProdutoRequest;
import br.com.desafiomercadolivre.repositorios.*;
import br.com.desafiomercadolivre.utils.UploaderSimulador;
import br.com.desafiomercadolivre.utils.mail.ServicoDeEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private OpiniaoRepository opiniaoRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private ServicoDeEmail servicoDeEmail;


    @PostMapping
    public ResponseEntity<?> salvarProduto(@RequestBody @Valid ProdutoRequest formulario, @AuthenticationPrincipal Usuario usuario){
        System.out.println("Usuario logado: " + usuario.getUsername());
        Produto produto = formulario.converterParaProduto(categoriaRepository, usuario);
        produtoRepository.save(produto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{idProduto}/imagens")
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

    @PostMapping("{idProduto}/opiniao")
    public ResponseEntity<?> cadastrarOpiniao(@RequestBody @Valid OpiniaoRequest formulario, @PathVariable Long idProduto,
                                              @AuthenticationPrincipal Usuario usuarioLogado){

        //Já esta validado pelo dto, se o produto existe ou não.
        Produto possivelProduto = produtoRepository.getById(idProduto);
        System.out.println(formulario.getDescricao());
        Opiniao novaOpiniao = formulario.converterParaOpiniao(usuarioLogado, possivelProduto);
        opiniaoRepository.save(novaOpiniao);
        return ResponseEntity.ok().build();
    }

    @PostMapping("{idProduto}/pergunta")
    public ResponseEntity<?> cadastrarPergunta(@RequestBody @Valid PerguntaRequest formulario, @PathVariable Long idProduto,
                                               @AuthenticationPrincipal Usuario usuario){

        Produto produto = produtoRepository.getById(idProduto);
        Pergunta pergunta = formulario.converterParaPergunta(produto, usuario);
        perguntaRepository.save(pergunta);
        servicoDeEmail.enviarEmail(pergunta, produto);
        return ResponseEntity.ok().build();
    }



}
