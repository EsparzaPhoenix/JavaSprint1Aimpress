package br.com.fiap.JavaSprint1Aimpress.repository;

import br.com.fiap.JavaSprint1Aimpress.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
