package FFEOE_BASE_DE_DATOS.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import FFEOE_BASE_DE_DATOS.Entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}