package br.com.desafiomercadolivre.controladores;

import br.com.desafiomercadolivre.exceptions.EstoqueInsuficiente;
import br.com.desafiomercadolivre.modelos.GatewayPagamento;
import br.com.desafiomercadolivre.modelos.NovaCompra;
import br.com.desafiomercadolivre.modelos.Produto;
import br.com.desafiomercadolivre.modelos.Usuario;
import br.com.desafiomercadolivre.modelos.formularios.NovaCompraRequest;
import br.com.desafiomercadolivre.repositorios.NovaCompraRepository;
import br.com.desafiomercadolivre.repositorios.ProdutoRepository;
import br.com.desafiomercadolivre.utils.mail.ServicoDeEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/compras")
public class CompraController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ServicoDeEmail servicoDeEmail;

    @Autowired
    private NovaCompraRepository novaCompraRepository;

    @PostMapping
    @Transactional
    public String registrarNovaCompra(@RequestBody @Valid NovaCompraRequest formulario,
                                                 @AuthenticationPrincipal Usuario usuario, UriComponentsBuilder uriComponentsBuilder){

        Produto produtoSelecionado = produtoRepository.getById(formulario.getProduto());

        if(produtoSelecionado.verificaEstoque(formulario.getQuantidade())){
            NovaCompra novaCompra = formulario.converterParaNovaCompra(usuario, produtoSelecionado);
            novaCompraRepository.save(novaCompra);
            servicoDeEmail.EmaailSinalizaCompra(novaCompra, produtoSelecionado);
            return novaCompra.retornarUrlGateway(uriComponentsBuilder);
        }

        throw new EstoqueInsuficiente("Este produto não possui a quantidade desejada disponivel.");
    }


}
