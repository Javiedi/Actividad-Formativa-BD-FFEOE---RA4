package FFEOE_BASE_DE_DATOS.Servicios;

import FFEOE_BASE_DE_DATOS.Entidades.Incidencia;
import FFEOE_BASE_DE_DATOS.Repositorios.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class IncidenciaServicio {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    public Incidencia guardarIncidencia(Incidencia incidencia) {
        if (incidencia.getDescripcion() == null || incidencia.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        incidencia.setEstado("Abierta");
        return incidenciaRepository.save(incidencia);
    }

    public Optional<Incidencia> obtenerPorId(Long id) {
        return incidenciaRepository.findById(id);
    }

    public boolean eliminarIncidencia(Long id) {
        if (incidenciaRepository.existsById(id)) {
            incidenciaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}