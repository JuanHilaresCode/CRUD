package pe.edu.vallegrande.crudweb.service;
import pe.edu.vallegrande.crudweb.connection.AccesoDB;
import pe.edu.vallegrande.crudweb.dto.RutasDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RutasService {

    public List<RutasDTO> getEliminados() {
        List<RutasDTO> eliminados = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = "SELECT route_id,origin,destination,distance,duration_in_minutes,description,status FROM routes WHERE status='0'";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                RutasDTO bean = new RutasDTO();
                bean.setRoute_id(rs.getInt("Route_id"));
                bean.setOrigin(rs.getString("Origin"));
                bean.setDestination(rs.getString("Destination"));
                bean.setDistance(Double.parseDouble(rs.getString("Distance")));
                bean.setDuration_in_minutes(Integer.parseInt(rs.getString("Duration_in_minutes")));
                bean.setDescription(rs.getString("Description"));
                bean.setStatus(String.valueOf(rs.getInt("Status")));
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

    public List<RutasDTO> getAll() {
        List<RutasDTO> lista = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = "SELECT route_id,origin,destination,distance,duration_in_minutes,description,status FROM routes WHERE status='1'";
            pstm = cn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                RutasDTO bean = new RutasDTO();
                bean.setRoute_id(rs.getInt("Route_id"));
                bean.setOrigin(rs.getString("Origin"));
                bean.setDestination(rs.getString("Destination"));
                bean.setDistance(Double.parseDouble(rs.getString("Distance")));
                bean.setDuration_in_minutes(Integer.parseInt(rs.getString("Duration_in_minutes")));
                bean.setDescription(rs.getString("Description"));
                bean.setStatus(String.valueOf(rs.getInt("Status")));
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
            sql = "SELECT route_id,origin,destination,distance,duration_in_minutes,description,status FROM routes WHERE route_id = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = new RutasDTO();
                bean.setRoute_id(rs.getInt("Route_id"));
                bean.setOrigin(rs.getString("Origin"));
                bean.setDestination(rs.getString("Destination"));
                bean.setDistance(Double.parseDouble(rs.getString("Distance")));
                bean.setDuration_in_minutes(Integer.parseInt(rs.getString("Duration_in_minutes")));
                bean.setDescription(rs.getString("Description"));
                bean.setStatus("Status");
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
            sql = "INSERT INTO routes(origin, destination, distance, duration_in_minutes, description, status) VALUES(?,?,?,?,?,?)";
            pstm = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, bean.getOrigin());
            pstm.setString(2, bean.getDestination());
            pstm.setString(3, String.valueOf(bean.getDistance()));
            pstm.setString(4, String.valueOf(bean.getDuration_in_minutes()));
            pstm.setString(5, bean.getDescription());
            pstm.setString(6, bean.getStatus());
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
            sql = "UPDATE routes SET origin = ?, destination = ?, distance = ?, duration_in_minutes = ?, description = ? WHERE route_id = ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, bean.getOrigin());
            pstm.setString(2, bean.getDestination());
            pstm.setString(3, String.valueOf(bean.getDistance()));
            pstm.setString(4, String.valueOf(bean.getDuration_in_minutes()));
            pstm.setString(5, bean.getDescription());
            pstm.setInt(6, bean.getRoute_id());
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
            sql = "UPDATE routes SET status = '0' WHERE route_id = ?";
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


    public boolean restaurar(int id) {
        Connection cn = null;
        PreparedStatement pstm = null;
        String sql;

        try {
            cn = AccesoDB.getConnection();
            sql = "UPDATE routes SET status = '1' WHERE route_id = ?";
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

