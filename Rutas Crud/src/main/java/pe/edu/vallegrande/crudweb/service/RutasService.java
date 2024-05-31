package pe.edu.vallegrande.crudweb.service;
import pe.edu.vallegrande.crudweb.connection.AccesoDB;
import pe.edu.vallegrande.crudweb.dto.RutasDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RutasService {
    public List<RutasDTO> getAll() {
        List<RutasDTO> lista = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = "SELECT id,origen,destino,distancia,duracion,descripcion,estado FROM rutas WHERE estado='1'";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                RutasDTO bean = new RutasDTO();
                bean.setId(rs.getInt("id"));
                bean.setOrigen(rs.getString("origen"));
                bean.setDestino(rs.getString("destino"));
                bean.setDistancia(rs.getString("distancia"));
                bean.setDuracion(rs.getString("duracion"));
                bean.setDescripcion(rs.getString("descripcion"));
                bean.setEstado(String.valueOf(rs.getInt("estado")));
                lista.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }


    public RutasDTO getById(int id) {
        RutasDTO bean = null;
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = "SELECT id,origen,destino,distancia,duracion,descripcion,estado FROM rutas WHERE id = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = new RutasDTO();
                bean.setId(rs.getInt("id"));
                bean.setOrigen(rs.getString("origen"));
                bean.setDestino(rs.getString("destino"));
                bean.setDistancia(rs.getString("distancia"));
                bean.setDuracion(rs.getString("duracion"));
                bean.setDescripcion(rs.getString("descripcion"));
                bean.setEstado("estado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    public int create(RutasDTO bean) {
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql;
        int nuevoRutaId = 0;

        try {
            cn = AccesoDB.getConnection();
            sql = "INSERT INTO rutas(origen, destino, distancia, duracion, descripcion, estado) VALUES(?,?,?,?,?,?)";
            pstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, bean.getOrigen());
            pstm.setString(2, bean.getDestino());
            pstm.setString(3, bean.getDistancia());
            pstm.setString(4, bean.getDuracion());
            pstm.setString(5, bean.getDescripcion());
            pstm.setString(6, bean.getEstado());
            pstm.executeUpdate();
            rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                nuevoRutaId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nuevoRutaId;
    }

    public void update(RutasDTO bean) {
        Connection cn = null;
        PreparedStatement pstm = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = "UPDATE rutas SET origen = ?, destino = ?, distancia = ?, duracion = ?, descripcion = ? WHERE id = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getOrigen());
            pstm.setString(2, bean.getDestino());
            pstm.setString(3, bean.getDistancia());
            pstm.setString(4, bean.getDuracion());
            pstm.setString(5, bean.getDescripcion());
            pstm.setInt(6, bean.getId());
            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected == 0) {
                bean = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean delete(int id) {
        Connection cn = null;
        PreparedStatement pstm = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = "UPDATE rutas SET estado = '0' WHERE id = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<RutasDTO> getEliminados() {
        List<RutasDTO> eliminados = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = "SELECT id,origen,destino,distancia,duracion,descripcion,estado FROM rutas WHERE estado='0'";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                RutasDTO bean = new RutasDTO();
                bean.setId(rs.getInt("id"));
                bean.setOrigen(rs.getString("origen"));
                bean.setDestino(rs.getString("destino"));
                bean.setDistancia(rs.getString("distancia"));
                bean.setDuracion(rs.getString("duracion"));
                bean.setDescripcion(rs.getString("descripcion"));
                bean.setEstado(String.valueOf(rs.getInt("estado")));
                eliminados.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return eliminados;
    }


    public boolean restaurar(int id) {
        Connection cn = null;
        PreparedStatement pstm = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = "UPDATE rutas SET estado = '1' WHERE id = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

