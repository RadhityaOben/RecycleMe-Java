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
                            "(id, nama, alamat, email, no_hp, status_registrasi, status_penjemputan, metode_pembayaran, poin)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setInt(1, masyarakat.getId());
            statement.setString(2, masyarakat.getNama());
            statement.setString(3, masyarakat.getAlamat());
            statement.setString(4, masyarakat.getEmail());
            statement.setString(5, masyarakat.getNoTelp());
            statement.setString(6, masyarakat.getStatusRegistrasi());
            statement.setString(7, masyarakat.getStatusPenjemputan());
            statement.setString(8, masyarakat.getMetodePembayaran());
            statement.setInt(9, masyarakat.getPoin());

            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Masyarakat masyarakat) {
        return 0;
    }

    public int delete(int id) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM masyarakat WHERE id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
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
}
