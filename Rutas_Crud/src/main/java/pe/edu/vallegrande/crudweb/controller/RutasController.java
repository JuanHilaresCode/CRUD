package pe.edu.vallegrande.crudweb.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pe.edu.vallegrande.crudweb.dto.RutasDTO;
import pe.edu.vallegrande.crudweb.service.RutasService;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet({"/ContGetAll", "/ContGetId", "/ContCrear", "/ContActualizar", "/ContBorrar", "/ContEditar","/ContGetEliminados","/ContRestaurar"})
public class RutasController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/ContGetAll":
                getAll(req, resp);
                break;
            case "/ContGetId":
                getById(req, resp);
                break;
            case "/ContEditar":
                getEdit(req, resp);
                break;
            case "/ContGetEliminados":
                getEliminados(req, resp);
                break;
        }
    }

    private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RutasDTO> lista;
        RutasService service = new RutasService();
        lista = service.getAll();
        req.setAttribute("lista", lista);
        RequestDispatcher rd = req.getRequestDispatcher("ruta.jsp");
        rd.forward(req, resp);
    }

    private void getEliminados(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RutasDTO> eliminados;
        RutasService service = new RutasService();
        eliminados = service.getEliminados();
        req.setAttribute("eliminados", eliminados);
        RequestDispatcher rd = req.getRequestDispatcher("eliminados.jsp");
        rd.forward(req, resp);
    }


    private void getById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        RutasService service = new RutasService();
        RutasDTO contacto = service.getById(id);

        if (contacto != null) {
            req.setAttribute("ruta", contacto);
            RequestDispatcher rd = req.getRequestDispatcher("detalleRuta.jsp");
            rd.forward(req, resp);
        } else {
            String mensaje = "El contacto con ID " + id + " no fue encontrado";
            req.setAttribute("mensaje", mensaje);
            resp.sendRedirect(req.getContextPath() + "/index.jsp?mensaje=" + URLEncoder.encode(mensaje, "UTF-8"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/ContCrear":
                contCreate(req, resp);
                break;
            case "/ContActualizar":
                contUpdate(req, resp);
                break;
            case "/ContBorrar":
                contDelete(req, resp);
                break;
            case "/ContRestaurar":
                restaurarRegistro(req, resp);
                break;
        }
    }

    private void contCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String origen = req.getParameter("origen");
        String destino = req.getParameter("destino");
        String distancia = req.getParameter("distancia");
        String duracion = req.getParameter("duracion");
        String descripcion = req.getParameter("descripcion");
        String estado = req.getParameter("estado");
        if (origen != null && !origen.isEmpty() && destino != null && !destino.isEmpty() && distancia != null && !distancia.isEmpty()
                && duracion != null && !duracion.isEmpty() && descripcion != null && !descripcion.isEmpty() && estado != null && !estado.isEmpty()) {
            RutasDTO nuevoruta = new RutasDTO();
            nuevoruta.setOrigen(origen);
            nuevoruta.setDestino(destino);
            nuevoruta.setDistancia(distancia);
            nuevoruta.setDuracion(duracion);
            nuevoruta.setDescripcion(descripcion);
            nuevoruta.setEstado(estado);

            RutasService service = new RutasService();
            int nuevorutaId = service.create(nuevoruta);

            if (nuevorutaId != 0) {
                String redirectURL = req.getContextPath() + "/ContGetId?id=" + nuevorutaId;
                resp.sendRedirect(redirectURL);
            } else {
                String mensaje = "Error al crear una nueva ruta";
                req.setAttribute("mensaje", mensaje);
                req.getRequestDispatcher("ruta.jsp").forward(req, resp);
            }
        } else {
            String mensaje = "Todos los campos deben ser obligatorios";
            req.setAttribute("mensaje", mensaje);
            req.getRequestDispatcher("ruta.jsp").forward(req, resp);
        }
    }

    private void contUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String origen = req.getParameter("origen");
        String destino = req.getParameter("destino");
        String distancia = req.getParameter("distancia");
        String duracion = req.getParameter("duracion");
        String descripcion = req.getParameter("descripcion");
        String estado = req.getParameter("estado");

        RutasService service = new RutasService();
        RutasDTO ruta = service.getById(id);

        if (ruta != null) {
            ruta.setOrigen(origen);
            ruta.setDestino(destino);
            ruta.setDistancia(distancia);
            ruta.setDuracion(duracion);
            ruta.setDescripcion(descripcion);
            ruta.setEstado(estado);
            service.update(ruta);
            resp.sendRedirect(req.getContextPath() + "/ContGetAll");
        } else {
            String mensaje = "La Ruta con ID " + id + " no fue encontrada";
            req.setAttribute("mensaje", mensaje);
            req.getRequestDispatcher("ruta.jsp").forward(req, resp);
        }
    }


    private void contDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        RutasService service = new RutasService();
        boolean eliminado = service.delete(id);

        if (eliminado) {
            String mensaje = "Ruta eliminada correctamente";
            req.setAttribute("mensaje", mensaje);
            resp.sendRedirect(req.getContextPath() + "/ContGetAll");
        } else {
            String mensaje = "La Ruta con el ID " + id + " no fue encontrado";
            req.setAttribute("mensaje", mensaje);
            resp.sendRedirect(req.getContextPath() + "/index.jsp?mensaje=" + URLEncoder.encode(mensaje, "UTF-8"));
        }
    }


    private void getEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        RutasService service = new RutasService();
        RutasDTO ruta = service.getById(id);

        if (ruta != null) {
            req.setAttribute("ruta", ruta);
            RequestDispatcher rd = req.getRequestDispatcher("editarRuta.jsp");
            rd.forward(req, resp);
        } else {
            String mensaje = "La ruta con ID " + id + " no fue encontrada";
            req.setAttribute("mensaje", mensaje);
            resp.sendRedirect(req.getContextPath() + "/index.jsp?mensaje=" + URLEncoder.encode(mensaje, "UTF-8"));
        }
    }

    private void restaurarRegistro(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        RutasService service = new RutasService();
        boolean restaurado = service.restaurar(id);

        if (restaurado) {
            String mensaje = "Registro restaurado correctamente";
            req.setAttribute("mensaje", mensaje);
            resp.sendRedirect(req.getContextPath() + "/ContGetEliminados");
        } else {
            String mensaje = "No se pudo restaurar el registro";
            req.setAttribute("mensaje", mensaje);
            resp.sendRedirect(req.getContextPath() + "/ContGetEliminados");
        }
    }

}
