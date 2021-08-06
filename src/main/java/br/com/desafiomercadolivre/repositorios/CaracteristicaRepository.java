package br.com.desafiomercadolivre.repositorios;

import br.com.desafiomercadolivre.modelos.CaracteristicaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepository extends JpaRepository<CaracteristicaProduto, Long> {


}
