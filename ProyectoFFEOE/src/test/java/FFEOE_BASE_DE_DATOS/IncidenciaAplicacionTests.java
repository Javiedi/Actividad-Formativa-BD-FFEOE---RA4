package FFEOE_BASE_DE_DATOS;

import FFEOE_BASE_DE_DATOS.Entidades.Incidencia;
import FFEOE_BASE_DE_DATOS.Repositorios.IncidenciaRepository;
import FFEOE_BASE_DE_DATOS.Servicios.IncidenciaServicio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class IncidenciaAplicacionTests {

    @Mock
    private IncidenciaRepository incidenciaRepository;

    @InjectMocks
    private IncidenciaServicio incidenciaServicio;

    @Test
    void testPruebaUnitaria_GuardarIncidenciaCorrectamente() {
        Incidencia inc = new Incidencia();
        inc.setDescripcion("Pantalla rota");

        Mockito.when(incidenciaRepository.save(Mockito.any(Incidencia.class))).thenReturn(inc);

        Incidencia guardada = incidenciaServicio.guardarIncidencia(inc);
        assertNotNull(guardada);
        assertEquals("Abierta", guardada.getEstado());
    }

    @Test
    void testPruebaUnitaria_ErrorAlGuardarDescripcionVacia() {
        Incidencia inc = new Incidencia();
        inc.setDescripcion("");

        assertThrows(IllegalArgumentException.class, () -> {
            incidenciaServicio.guardarIncidencia(inc);
        });
    }

    @Test
    void testPruebaUnitaria_EliminarIncidenciaNoExistente() {
        Mockito.when(incidenciaRepository.existsById(999L)).thenReturn(false);
        boolean resultado = incidenciaServicio.eliminarIncidencia(999L);
        assertFalse(resultado);
    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPruebaIntegracion_GetIncidenciasEndpoint() throws Exception {

        mockMvc.perform(get("/incidencias"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}