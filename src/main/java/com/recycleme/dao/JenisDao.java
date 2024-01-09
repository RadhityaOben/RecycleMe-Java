package com.recycleme.dao;

import com.recycleme.db.MySqlConnection;
import com.recycleme.model.jenis.Jenis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JenisDao {
    public int insert(Jenis jenis) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO jenis " +
                            "(id, nama, id_kategori, poin)" +
                            "VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, jenis.getId());
            statement.setString(2, jenis.getNama());
            statement.setInt(3, jenis.getKategori().getId());
            statement.setInt(4, jenis.getPoin());

            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Jenis jenis) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE jenis SET nama = ?, id_kategori = ?, poin = ? WHERE id = ?"
            );
            statement.setString(1, jenis.getNama());
            statement.setInt(2, jenis.getKategori().getId());
            statement.setInt(3, jenis.getId());
            statement.setInt(4, jenis.getPoin());

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
                    "DELETE FROM jenis WHERE id = ?"
            );
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Jenis> findAll() {
        List<Jenis> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM jenis");) {
                while (resultSet.next()) {
                    Jenis jenis = new Jenis();
                    jenis.setId(resultSet.getInt("id"));
                    jenis.setNama(resultSet.getString("nama"));
                    jenis.setKategori(new KategoriDao().findById(resultSet.getInt("id_kategori")));
                    jenis.setPoin(resultSet.getInt("poin"));
                    list.add(jenis);
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
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM jenis");) {
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
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT COUNT(*) FROM jenis"
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

    public Jenis findById(int id) {
        Jenis jenis = new Jenis();
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM jenis WHERE id = ?"
            );
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                jenis.setId(resultSet.getInt("id"));
                jenis.setNama(resultSet.getString("nama"));
                jenis.getKategori().setId(resultSet.getInt("id_kategori"));
                jenis.setPoin(resultSet.getInt("poin"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return jenis;
    }
}