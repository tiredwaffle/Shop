package com.edu.dao.impl;

import com.edu.connection.ConnectionFactory;
import com.edu.dao.ItemDao;
import com.edu.entities.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    private Connection connection;
    private PreparedStatement statement;

    public ItemDaoImpl(Connection connection) {
        this.statement = null;
        this.connection = connection;
    }


    @Override
    public void create(Item entity) {
        try {
            connection = getConnection();
            String queryString = "INSERT INTO items (amountAvailable, weight, price, name) VALUES(?,?,?,?)";
            statement = connection.prepareStatement(queryString);
            //statement.setInt(1, entity.getId());
            statement.setFloat(1, entity.getAmountAvailable());
            statement.setFloat(2, entity.getWeight());
            statement.setFloat(3, entity.getPrice());
            statement.setString(4, entity.getName());
            statement.executeUpdate();
            System.out.println("Item Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public Item findById(int id) {
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM Items WHERE id=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                float amountAvailable = resultSet.getFloat("amountAvailable");
                float weight = resultSet.getFloat("weight");
                float price = resultSet.getFloat("price");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id
                        + ", amountAvailable: " + amountAvailable
                        + ", weight: " + weight
                        + ", price: " + price
                        + ", name: " + name);
                return new Item(id, amountAvailable, weight,price, name);
            } else {
                System.out.println("Item not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public LinkedList<Item> findAll() {
        ResultSet resultSet = null;
        List<Item> ll = new LinkedList<Item>();
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM items";
            statement = connection.prepareStatement(queryString);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                float amountAvailable = resultSet.getFloat("amountAvailable");
                float weight = resultSet.getFloat("weight");
                float price = resultSet.getFloat("price");
                String name = resultSet.getString("name");
                Item item = new Item(id, amountAvailable, weight, price, name);
                ll.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (LinkedList<Item>) ll;
    }

    @Override
    public void update(Item entity) {
        try {
            connection = getConnection();
            String queryString = "UPDATE Items SET amountAvailable=?, weight=?, price=?, name=? WHERE Id = ?";
            statement = connection.prepareStatement(queryString);
            statement.setFloat(1, entity.getAmountAvailable());
            statement.setFloat(2, entity.getWeight());
            statement.setFloat(3, entity.getPrice());
            statement.setString(4, entity.getName());
            statement.setInt(5, entity.getId());
            statement.executeUpdate();
            System.out.println("Item updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void delete(int id) {
        try {
            connection = getConnection();
            String queryString = "DELETE FROM Items WHERE id=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Item deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void changeAmount(int id, float newAmount) {
        try {
            connection = getConnection();
            String queryString = "UPDATE Items SET amountAvailable=? WHERE Id = ?";
            statement = connection.prepareStatement(queryString);
            statement.setFloat(1, newAmount);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Item's amountAvailable updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public Item findByName(String partOfName) {
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String queryString;
            queryString = "SELECT * FROM Items WHERE lower(name) = lower(?)";
            statement = connection.prepareStatement(queryString);
            statement.setString(1, partOfName);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                float amountAvailable = resultSet.getFloat("amountAvailable");
                float weight = resultSet.getFloat("weight");
                float price = resultSet.getFloat("price");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id
                        + ", amountAvailable: " + amountAvailable
                        + ", weight: " + weight
                        + ", price: " + price
                        + ", name: " + name);
                return new Item(id, amountAvailable, weight,price, name);
            } else {
                System.out.println("Item not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
}
