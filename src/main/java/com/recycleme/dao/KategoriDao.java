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
                            "(nama" +
                            "VALUES (?, ?)"
            );
            statement.setString(1, kategori.getNama());


            result = statement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Kategori kategori) {
        return 0;
    }

    public int delete(int id) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM kategori WHERE id = ?"
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
                    "SELECT id FROM kategori ORDER BY id DESC LIMIT 1"
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
                    "SELECT COUNT(*) FROM kategori"
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

    public static Kategori findById(int id) {
        Kategori kategori = null;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM kategori WHERE id = ?"
            );
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                kategori = new Kategori(
                        resultSet.getInt("id"),
                        resultSet.getString("nama")
                );
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return kategori;
    }

public static List<Kategori> findAll() {
        List<Kategori> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM kategori"
            );
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                list.add(new Kategori(
                        resultSet.getInt("id"),
                        resultSet.getString("nama")
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Kategori> findAll(int page, int limit) {
        List<Kategori> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM kategori LIMIT ?, ?"
            );
            statement.setInt(1, (page - 1) * limit);
            statement.setInt(2, limit);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                list.add(new Kategori(
                        resultSet.getInt("id"),
                        resultSet.getString("nama")
                ));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
