package br.com.desafiomercadolivre.repositorios;

import br.com.desafiomercadolivre.modelos.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

}
