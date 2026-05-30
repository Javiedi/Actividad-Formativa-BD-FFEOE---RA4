package FFEOE_BASE_DE_DATOS.Controladores;

import FFEOE_BASE_DE_DATOS.Entidades.Incidencia;
import FFEOE_BASE_DE_DATOS.Repositorios.IncidenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaControlador {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    @GetMapping
    public List<Incidencia> obtenerTodas() {
        return incidenciaRepository.findAll();
    }

    @PostMapping
    public Incidencia crearIncidencia(@RequestBody Incidencia nuevaIncidencia) {
        nuevaIncidencia.setEstado("Abierta");
        return incidenciaRepository.save(nuevaIncidencia);
    }

    @PutMapping("/{id}")
    public Incidencia actualizarIncidencia(@PathVariable Long id, @RequestBody Incidencia datosActualizados) {
        Optional<Incidencia> incidenciaExistente = incidenciaRepository.findById(id);

        if (incidenciaExistente.isPresent()) {
            Incidencia incidencia = incidenciaExistente.get();

            // Solo actualiza si el dato que viene no es nulo
            if (datosActualizados.getDescripcion() != null) {
                incidencia.setDescripcion(datosActualizados.getDescripcion());
            }
            if (datosActualizados.getEstado() != null) {
                incidencia.setEstado(datosActualizados.getEstado());
            }

            return incidenciaRepository.save(incidencia);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String eliminarIncidencia(@PathVariable Long id) {
        incidenciaRepository.deleteById(id);
        return "Incidencia eliminada correctamente.";
    }
}
