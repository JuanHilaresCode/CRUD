package pe.edu.vallegrande.crudweb.dto;

import lombok.*;
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class RutasDTO {
    private int route_id;
    private String origin;
    private String destination;
    private double distance;
    private int duration_in_minutes;
    private String description;
    private String status;
}