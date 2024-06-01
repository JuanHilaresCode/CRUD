package pe.edu.vallegrande.crudweb.dto;

import lombok.*;
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class RutasDTO {
    private int id;
    private String origen;
    private String destino;
    private String distancia;
    private String duracion;
    private String descripcion;
    private String estado;
}

