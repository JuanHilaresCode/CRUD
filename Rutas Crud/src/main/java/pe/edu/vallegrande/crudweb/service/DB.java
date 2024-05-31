package pe.edu.vallegrande.crudweb.service;

import pe.edu.vallegrande.crudweb.dto.RutasDTO;

import java.util.ArrayList;
import java.util.List;

public class DB {
    private DB() {

    }

    static List<RutasDTO> rutas;
    static int contador;

    static {
        rutas = new ArrayList<>();
        rutas.add(new RutasDTO(1, "Ciudad A", "Ciudad 1", "100 km", "2 horas", "Ruta panoramica por la costa", "1"));
        rutas.add(new RutasDTO(2, "Ciudad B", "Ciudad 2", "100 km", "2 horas", "Ruta panoramica por la costa", "1"));
        rutas.add(new RutasDTO(3, "Ciudad C", "Ciudad 3", "100 km", "2 horas", "Ruta panoramica por la costa", "1"));
        rutas.add(new RutasDTO(4, "Ciudad D", "Ciudad 4", "100 km", "2 horas", "Ruta panoramica por la costa", "1"));
        rutas.add(new RutasDTO(5, "Ciudad E", "Ciudad 5", "100 km", "2 horas", "Ruta panoramica por la costa", "1"));
        rutas.add(new RutasDTO(6, "Ciudad F", "Ciudad 6", "100 km", "2 horas", "Ruta panoramica por la costa", "1"));
        rutas.add(new RutasDTO(7, "Ciudad G", "Ciudad 7", "100 km", "2 horas", "Ruta panoramica por la costa", "1"));
        contador = 7;
    }
}
