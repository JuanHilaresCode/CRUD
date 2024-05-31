package pe.edu.vallegrande.crudweb.test;

import pe.edu.vallegrande.crudweb.dto.RutasDTO;
import pe.edu.vallegrande.crudweb.service.RutasService;

import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        RutasService service = new RutasService();
        List<RutasDTO> lista = service.getAll();
        System.out.println(lista);
    }
}
