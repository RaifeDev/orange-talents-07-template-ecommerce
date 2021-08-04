package br.com.desafiomercadolivre.repositorios;

import br.com.desafiomercadolivre.modelos.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
