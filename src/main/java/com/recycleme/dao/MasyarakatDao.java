package com.recycleme.dao;

import com.recycleme.db.MySqlConnection;
import com.recycleme.model.masyarakat.Masyarakat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MasyarakatDao {
    public int insert(Masyarakat masyarakat) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO masyarakat " +
                            "(nama, alamat, email, no_hp, status_registrasi, status_penjemputan, metode_pembayaran, poin)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, masyarakat.getNama());
            statement.setString(2, masyarakat.getAlamat());
            statement.setString(3, masyarakat.getEmail());
            statement.setString(4, masyarakat.getNoTelp());
            statement.setString(5, masyarakat.getStatusRegistrasi());
            statement.setString(6, masyarakat.getStatusPenjemputan());
            statement.setString(7, masyarakat.getMetodePembayaran());
            statement.setInt(8, masyarakat.getPoin());

            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Masyarakat masyarakat) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE masyarakat SET " +
                            "nama = ?, " +
                            "alamat = ?, " +
                            "email = ?, " +
                            "no_hp = ?, " +
                            "status_registrasi = ?, " +
                            "status_penjemputan = ?, " +
                            "metode_pembayaran = ?, " +
                            "poin = ? " +
                            "WHERE id = ?"
            );
            statement.setString(1, masyarakat.getNama());
            statement.setString(2, masyarakat.getAlamat());
            statement.setString(3, masyarakat.getEmail());
            statement.setString(4, masyarakat.getNoTelp());
            statement.setString(5, masyarakat.getStatusRegistrasi());
            statement.setString(6, masyarakat.getStatusPenjemputan());
            statement.setString(7, masyarakat.getMetodePembayaran());
            statement.setInt(8, masyarakat.getPoin());
            statement.setInt(9, masyarakat.getId());

            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public int delete(int id) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM dropbox WHERE id_masyarakat = ?"
            );
            statement.setInt(1, id);
            result = statement.executeUpdate();

            statement = connection.prepareStatement(
                    "DELETE FROM masyarakat WHERE id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int lastId() {
        int lastId = 0;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id FROM masyarakat ORDER BY id DESC LIMIT 1"
            );
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                lastId = resultSet.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lastId;
    }

    public static int total() {
        int total = 0;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT COUNT(*) FROM masyarakat"
            );
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                total = resultSet.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public List<Masyarakat> findAll() {
        List<Masyarakat> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM masyarakat");) {
                while (resultSet.next()) {
                    Masyarakat masyarakat = new Masyarakat();
                    masyarakat.setId(resultSet.getInt("id"));
                    masyarakat.setNama(resultSet.getString("nama"));
                    masyarakat.setAlamat(resultSet.getString("alamat"));
                    masyarakat.setEmail(resultSet.getString("email"));
                    masyarakat.setNoTelp(resultSet.getString("no_hp"));
                    masyarakat.setStatusRegistrasi(resultSet.getString("status_registrasi"));
                    masyarakat.setStatusPenjemputan(resultSet.getString("status_penjemputan"));
                    masyarakat.setMetodePembayaran(resultSet.getString("metode_pembayaran"));
                    masyarakat.setPoin(resultSet.getInt("poin"));
                    list.add(masyarakat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static Masyarakat findById(int id) {
        Masyarakat masyarakat = new Masyarakat();
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM masyarakat WHERE id = ?"
            );
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                masyarakat.setId(resultSet.getInt("id"));
                masyarakat.setNama(resultSet.getString("nama"));
                masyarakat.setAlamat(resultSet.getString("alamat"));
                masyarakat.setEmail(resultSet.getString("email"));
                masyarakat.setNoTelp(resultSet.getString("no_hp"));
                masyarakat.setStatusRegistrasi(resultSet.getString("status_registrasi"));
                masyarakat.setStatusPenjemputan(resultSet.getString("status_penjemputan"));
                masyarakat.setMetodePembayaran(resultSet.getString("metode_pembayaran"));
                masyarakat.setPoin(resultSet.getInt("poin"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return masyarakat;
    }
}
