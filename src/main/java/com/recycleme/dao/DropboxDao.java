package com.recycleme.dao;

import com.recycleme.db.MySqlConnection;
import com.recycleme.model.dropbox.Dropbox;
import com.recycleme.model.kurir.Kurir;
import com.recycleme.model.masyarakat.Masyarakat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DropboxDao {
    private int executeUpdate(String query, Dropbox dropbox) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dropbox.getNama());
            statement.setString(2, dropbox.getAlamat());
            statement.setInt(3, dropbox.getMasyarakat().getId());
            statement.setInt(4, dropbox.getKurir().getId());
            // statement.setInt(5, dropbox.getJenis().getId());
            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int insert(Dropbox dropbox) {
        return executeUpdate(
                "INSERT INTO dropbox " +
                        "(nama, alamat, id_masyarakat, id_kurir)" +
                        "VALUES (?, ?, ?, ?)",
                dropbox
        );
    }

    public int update(Dropbox dropbox) {
        return executeUpdate(
                "UPDATE dropbox SET nama = ?, alamat = ?, id_masyarakat = ?, id_kurir = ? WHERE id = ?",
                dropbox
        );
    }

    public int delete(int id) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM dropbox WHERE id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Dropbox> findAll() {
        List<Dropbox> dropboxList = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT d.id, d.nama, d.lokasi, m.id AS id_masyarakat, k.id AS id_kurir " +
                            "FROM dropbox d " +
                            "JOIN masyarakat m ON d.id_masyarakat = m.id " +
                            "JOIN kurir k ON d.id_kurir = k.id"
            )) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Dropbox dropbox = new Dropbox();
                dropbox.setId(resultSet.getInt("id"));
                dropbox.setNama(resultSet.getString("nama"));
                dropbox.setAlamat(resultSet.getString("alamat"));

                Masyarakat masyarakat = new Masyarakat();
                masyarakat.setId(resultSet.getInt("id_masyarakat"));

                Kurir kurir = new Kurir();
                kurir.setId(resultSet.getInt("id_kurir"));
                dropboxList.add(dropbox);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return dropboxList;
    }
}
