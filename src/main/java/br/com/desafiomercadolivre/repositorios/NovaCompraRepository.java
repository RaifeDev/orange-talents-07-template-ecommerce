package br.com.desafiomercadolivre.repositorios;

import br.com.desafiomercadolivre.modelos.NovaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovaCompraRepository extends JpaRepository<NovaCompra, Long> {



}
