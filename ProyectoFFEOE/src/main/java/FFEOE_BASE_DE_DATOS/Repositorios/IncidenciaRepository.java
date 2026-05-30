// Archivo: IncidenciaRepository.java
package FFEOE_BASE_DE_DATOS.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import FFEOE_BASE_DE_DATOS.Entidades.Incidencia;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
}
