package com.recycleme.dao;

import com.recycleme.db.MySqlConnection;
import com.recycleme.model.dropbox.Dropbox;
import com.recycleme.model.jenis.Jenis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DropboxDao {

    private int executeUpdate(String query, Dropbox dropbox) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, dropbox.getId());
            statement.setDate(2, dropbox.getTanggal());
            statement.setInt(3, dropbox.getMasyarakat().getId());
            statement.setInt(4, dropbox.getKurir().getId());
            statement.setInt(5, dropbox.getKategori().getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int insert(Dropbox dropbox) {
        return executeUpdate(
                  "INSERT INTO dropbox " +
                        "(id, tanggal, id_masyarakat, id_kurir, id_kategori) VALUES (?, ?, ?, ?, ?)", dropbox
        );
    }

    public int update(Dropbox dropbox) {
        return executeUpdate(
                  "UPDATE dropbox SET tanggal = ?, id_masyarakat = ?, id_kurir = ?, id_kategori = ? WHERE id = ?", dropbox
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
        List<Dropbox> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM dropbox");) {
                while (resultSet.next()) {
                    Dropbox dropbox = new Dropbox();
                    dropbox.setId(resultSet.getInt("id"));
                    dropbox.setTanggal(resultSet.getDate("tanggal"));
                    dropbox.setMasyarakat(new MasyarakatDao().findById(resultSet.getInt("id_masyarakat")));
                    dropbox.setKurir(new KurirDao().findById(resultSet.getInt("id_kurir")));
                    dropbox.setKategori(new KategoriDao().findById(resultSet.getInt("id_kategori")));
                    list.add(dropbox);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public Dropbox findById(int id) {
        Dropbox dropbox = new Dropbox();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM dropbox WHERE id = ?");) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                if (resultSet.next()) {
                    dropbox.setId(resultSet.getInt("id"));
                    dropbox.setTanggal(resultSet.getDate("tanggal"));
                    dropbox.setMasyarakat(new MasyarakatDao().findById(resultSet.getInt("id_masyarakat")));
                    dropbox.setKurir(new KurirDao().findById(resultSet.getInt("id_kurir")));
                    dropbox.setKategori(new KategoriDao().findById(resultSet.getInt("id_kategori")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dropbox;
    }

    public static int lastId() {
        int lastId = 0;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT id FROM dropbox ORDER BY id DESC LIMIT 1");) {
                if (resultSet.next()) {
                    lastId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastId;
    }

    public static int total() {
        int total = 0;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM dropbox");) {
                if (resultSet.next()) {
                    total = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
}
