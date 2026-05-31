package FFEOE_BASE_DE_DATOS.Controladores;

import FFEOE_BASE_DE_DATOS.Entidades.Incidencia;
import FFEOE_BASE_DE_DATOS.Servicios.IncidenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaControlador {

    @Autowired
    private IncidenciaServicio incidenciaServicio;

    @GetMapping
    public List<Incidencia> obtenerTodas() {
        return new ArrayList<>();
    }

    @PostMapping
    public Incidencia crearIncidencia(@RequestBody Incidencia nuevaIncidencia) {
        return incidenciaServicio.guardarIncidencia(nuevaIncidencia);
    }

    @PutMapping("/{id}")
    public Incidencia actualizarIncidencia(@PathVariable Long id, @RequestBody Incidencia datosActualizados) {
        Optional<Incidencia> incidenciaExistente = incidenciaServicio.obtenerPorId(id);

        if (incidenciaExistente.isPresent()) {
            Incidencia incidencia = incidenciaExistente.get();

            if (datosActualizados.getDescripcion() != null) {
                incidencia.setDescripcion(datosActualizados.getDescripcion());
            }
            if (datosActualizados.getEstado() != null) {
                incidencia.setEstado(datosActualizados.getEstado());
            }

            return incidenciaServicio.guardarIncidencia(incidencia);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String eliminarIncidencia(@PathVariable Long id) {
        boolean eliminado = incidenciaServicio.eliminarIncidencia(id);
        if (eliminado) {
            return "Incidencia eliminada correctamente.";
        } else {
            return "Error: No se encontró la incidencia.";
        }
    }
}