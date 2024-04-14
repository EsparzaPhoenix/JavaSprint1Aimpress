package br.com.fiap.JavaSprint1Aimpress.repository;

import br.com.fiap.JavaSprint1Aimpress.model.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
}
