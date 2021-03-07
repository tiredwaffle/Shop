package com.edu.dao.impl;

import com.edu.connection.ConnectionFactory;
import com.edu.dao.CheckItemDao;
import com.edu.entities.Check;
import com.edu.entities.CheckItem;
import com.edu.entities.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CheckItemDaoImpl  implements CheckItemDao {

    private Connection connection;
    private PreparedStatement statement;

    public CheckItemDaoImpl(Connection connection) {
        this.statement = null;
        this.connection = connection;
    }

    @Override
    public void refundItem(int checkId, int itemId) {
        try {
            connection = getConnection();
            String queryString = "DELETE FROM CheckItems WHERE checkId=? and itemId=?";//"UPDATE CheckItems SET active=0 WHERE checkId=? and itemId=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, checkId);
            statement.setInt(2, itemId);
            statement.executeUpdate();
            System.out.println("Check item refunded successfully!");
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
    public void create(CheckItem entity) {
        try {
            connection = getConnection();
            //int id, int checkId, int itemId, float itemAmount, float itemWeight, float itemPrice, Boolean active)
            String queryString = "INSERT INTO checkItems (checkId, itemId, itemAmount, itemWeight, itemPrice, active) VALUES(?,?,?,?,?,?)";
            statement = connection.prepareStatement(queryString);
            //statement.setInt(1, entity.getId());
            statement.setInt(1, entity.getCheckId());
            statement.setInt(2, entity.getItemId());
            statement.setFloat(3, entity.getItemAmount());
            statement.setFloat(4, entity.getItemWeight());
            statement.setFloat(5, entity.getItemPrice());
            statement.setBoolean(6, entity.getActive());
            statement.executeUpdate();
            System.out.println("Check item added successfully");
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
    public CheckItem findById(int id) {
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM CheckItems WHERE id=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                //int id, int checkId, int itemId, float itemAmount, float itemWeight, float itemPrice, Boolean active)
                int checkId = resultSet.getInt("checkId");
                int itemId = resultSet.getInt("itemId");
                float itemAmount = resultSet.getFloat("itemAmount");
                float itemWeight = resultSet.getFloat("itemWeight");
                float itemPrice = resultSet.getFloat("itemPrice");
                boolean active = resultSet.getBoolean("active");
                CheckItem checkItem = new CheckItem(id,checkId, itemId, itemAmount, itemWeight, itemPrice, active);
                System.out.println("ID: " + id
                        + ", checkId: " + checkId
                        + ", itemId: " + itemId
                        + ", itemAmount: " + itemAmount
                        + ", itemWeight: " + itemWeight
                        + ", itemPrice: " + itemPrice
                        + ", active: " + Boolean.toString(active));
                return checkItem;
            } else {
                System.out.println("Check item not found");
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
            return null;
        }
    }

    @Override
    public LinkedList<CheckItem> findByCheckId(int checkId) {
        ResultSet resultSet = null;
        LinkedList<CheckItem> items = new LinkedList<CheckItem>();
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM CheckItems WHERE checkId=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, checkId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                int itemId = resultSet.getInt("itemId");
                float itemAmount = resultSet.getFloat("itemAmount");
                float itemWeight = resultSet.getFloat("itemWeight");
                float itemPrice = resultSet.getFloat("itemPrice");
                boolean active = resultSet.getBoolean("active");
                CheckItem checkItem = new CheckItem(id, checkId, itemId, itemAmount, itemWeight, itemPrice, active);
                System.out.println("ID: " + id
                        + ", checkId: " + checkId
                        + ", itemId: " + itemId
                        + ", itemAmount: " + itemAmount
                        + ", itemWeight: " + itemWeight
                        + ", itemPrice: " + itemPrice
                        + ", active: " + Boolean.toString(active));
                items.add(checkItem);
            }
            return items;
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
    public LinkedList<CheckItem> findAll() {
        ResultSet resultSet = null;
        List<CheckItem> ll = new LinkedList<CheckItem>();
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM CheckItems";
            statement = connection.prepareStatement(queryString);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int checkId = resultSet.getInt("checkId");
                int itemId = resultSet.getInt("itemId");
                float itemAmount = resultSet.getFloat("itemAmount");
                float itemWeight = resultSet.getFloat("itemWeight");
                float itemPrice = resultSet.getFloat("itemPrice");
                boolean active = resultSet.getBoolean("active");
                CheckItem checkItem = new CheckItem(id, checkId, itemId, itemAmount, itemWeight, itemPrice, active);
                ll.add(checkItem);
            } else {
                System.out.println("Check items not found");
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
        return (LinkedList<CheckItem>) ll;
    }

    @Override
    public void update(CheckItem entity) {
        try {
            connection = getConnection();
            String queryString = "UPDATE CheckItems SET checkId=?, itemId=?, itemAmount=?, itemWeight=?, itemPrice=?, active=? WHERE Id = ?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, entity.getCheckId());
            statement.setInt(2, entity.getItemId());
            statement.setFloat(3, entity.getItemAmount());
            statement.setFloat(4, entity.getItemWeight());
            statement.setFloat(5, entity.getItemPrice());
            statement.setBoolean(3, entity.getActive());
            statement.setInt(4, entity.getId());
            statement.executeUpdate();
            System.out.println("Check item updated successfully!");
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
            String queryString = "DELETE FROM CheckItems WHERE id=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Check item deleted successfully!");
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



    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
}
