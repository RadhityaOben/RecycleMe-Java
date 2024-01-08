package com.recycleme.dao;

import com.recycleme.db.MySqlConnection;
import com.recycleme.model.kategori.Kategori;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KategoriDao {
    public int insert(Kategori kategori) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO kategori " +
                            "(id, nama)" +
                            "VALUES (?, ?)"
            );
            statement.setInt(1, kategori.getId());
            statement.setString(2, kategori.getNama());

            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Kategori kategori) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE kategori SET nama = ? WHERE id = ?"
            );
            statement.setString(1, kategori.getNama());
            statement.setInt(2, kategori.getId());

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
                    "DELETE FROM dropbox WHERE id_kategori = ?"
            );
            statement.setInt(1, id);
            result = statement.executeUpdate();

            statement = connection.prepareStatement(
                    "DELETE FROM jenis WHERE id_kategori = ?"
            );
            statement.setInt(1, id);
            result = statement.executeUpdate();

            statement = connection.prepareStatement(
                    "DELETE FROM kategori WHERE id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Kategori> findAll() {
        List<Kategori> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM kategori");) {
                while (resultSet.next()) {
                    Kategori kategori = new Kategori();
                    kategori.setId(resultSet.getInt("id"));
                    kategori.setNama(resultSet.getString("nama"));
                    list.add(kategori);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static int lastId() {
        int lastId = 0;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT id FROM kategori ORDER BY id DESC LIMIT 1");) {
                while (resultSet.next()) {
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
            try (ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM kategori");) {
                while (resultSet.next()) {
                    total = resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }

    public Kategori findById(int id) {
        Kategori kategori = new Kategori();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM kategori WHERE id = ?");) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    kategori.setId(resultSet.getInt("id"));
                    kategori.setNama(resultSet.getString("nama"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kategori;
    }
}
