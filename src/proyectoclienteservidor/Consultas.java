package proyectoclienteservidor;

import java.sql.*;

public class Consultas extends Conexion {

    public boolean registrar(Vehiculo v) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO Vehiculo (placa, propietario, tipoVehiculo) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getPropietaio());
            ps.setString(3, Vehiculo.class.getSimpleName());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Vehiculo v) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE Vehiculo SET propietario = ?, tipo = ? WHERE placa = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getPlaca());
            ps.setString(2, v.getPropietaio());
            ps.setString(3, Vehiculo.class.getSimpleName());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Vehiculo v) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM Vehiculo WHERE placa = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getPlaca());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Vehiculo v) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM Vehiculo WHERE placa=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getPlaca());
            rs = ps.executeQuery();

            if (rs.next()) {
                v.setPlaca(rs.getString("placa"));
                v.setPropietaio(rs.getString("propietario"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
