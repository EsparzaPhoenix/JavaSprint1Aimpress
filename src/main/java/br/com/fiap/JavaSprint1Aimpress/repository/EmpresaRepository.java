package br.com.fiap.JavaSprint1Aimpress.repository;

import br.com.fiap.JavaSprint1Aimpress.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
