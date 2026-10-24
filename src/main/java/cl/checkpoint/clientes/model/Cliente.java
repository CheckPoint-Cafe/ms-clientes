package cl.checkpoint.clientes.model;

import jakarta.persistence.*;

@Entity
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  private String correo;
  private String telefono;

  public Long getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String value) {
    this.nombre = value;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String value) {
    this.correo = value;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String value) {
    this.telefono = value;
  }
}
