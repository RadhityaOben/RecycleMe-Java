package com.recycleme.dao;

import com.recycleme.db.MySqlConnection;
import com.recycleme.model.kurir.Kurir;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class KurirDao {
    public int insert(Kurir kurir) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO kurir " +
                            "(nama, no_hp, status_registrasi, status_penjemputan, jenis_kendaraan, kelengkapan_berkas)" +
                            "VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, kurir.getNama());
            statement.setString(2, kurir.getNoHp());
            statement.setString(3, kurir.getStatusRegistrasi());
            statement.setString(4, kurir.getStatusPenjemputan());
            statement.setString(5, kurir.getJenisKendaraan());
            statement.setString(6, kurir.getKelengkapanBerkas());

            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Kurir kurir) {
        return 0;
    }

    public int delete(int id) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM kurir WHERE id = ?"
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
                    "SELECT id FROM kurir ORDER BY id DESC LIMIT 1"
            );
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                lastId = resultSet.getInt("id");
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
                    "SELECT COUNT(*) FROM kurir"
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

    public List<Kurir> findAll() {
        List<Kurir> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM kurir");) {
                while (resultSet.next()) {
                    Kurir kurir = new Kurir();
                    kurir.setId(resultSet.getInt("id"));
                    kurir.setNama(resultSet.getString("nama"));
                    kurir.setNoHp(resultSet.getString("no_hp"));
                    kurir.setStatusRegistrasi(resultSet.getString("status_registrasi"));
                    kurir.setStatusPenjemputan(resultSet.getString("status_penjemputan"));
                    kurir.setJenisKendaraan(resultSet.getString("jenis_kendaraan"));
                    kurir.setKelengkapanBerkas(resultSet.getString("kelengkapan_berkas"));
                    list.add(kurir);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
