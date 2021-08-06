package br.com.desafiomercadolivre.repositorios;

import br.com.desafiomercadolivre.modelos.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {



}
