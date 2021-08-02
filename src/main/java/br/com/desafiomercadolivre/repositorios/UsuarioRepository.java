package br.com.desafiomercadolivre.repositorios;

import br.com.desafiomercadolivre.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {




}
