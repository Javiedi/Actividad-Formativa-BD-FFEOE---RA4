package FFEOE_BASE_DE_DATOS.Entidades;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "incidencias")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String estado;

    // Relación: Muchas incidencias pertenecen a un usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    @JsonIgnoreProperties("incidencias") // Evita el bucle infinito al convertir a JSON
    private Usuario usuario;

    // Constructor vacío obligatorio para Hibernate
    public Incidencia() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}