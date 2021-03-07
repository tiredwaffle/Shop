package com.edu.dao.impl;

import com.edu.connection.ConnectionFactory;
import com.edu.dao.CheckDao;
import com.edu.entities.Check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CheckDaoImpl implements CheckDao {

    private Connection connection;
    private PreparedStatement statement;

    public CheckDaoImpl(Connection connection) {
        this.statement = null;
        this.connection = connection;
    }

    @Override
    public void cancelCheck(int id) {
        try {
            connection = getConnection();
            String queryString = "UPDATE Checks SET active = False WHERE id=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Check canceled successfully!");
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
    public void create(Check entity) {
        try {
            connection = getConnection();
            //int id, int createdBy, float amount, Boolean active
            String queryString = "INSERT INTO checks (createdBy, amount, active) VALUES(?,?,?)";
            statement = connection.prepareStatement(queryString);
            //statement.setInt(1, entity.getId());
            statement.setInt(1, entity.getCreatedBy());
            statement.setFloat(2, entity.getAmount());
            statement.setBoolean(3, entity.getActive());
            statement.executeUpdate();
            System.out.println("Check added successfully");
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
    public Check findById(int id) {
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM Checks WHERE id=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                Check check = new Check();
                check.setId(id);
                check.setActive(resultSet.getBoolean("active"));
                check.setAmount(resultSet.getFloat("amount"));
                check.setCreatedBy(resultSet.getInt("createdBy"));
//                int createdBy = resultSet.getInt("createdBy");
//                float amount = resultSet.getFloat("amount");
//                boolean active = resultSet.getBoolean("active");
                System.out.println(check.toString());
                return check;
            } else {
                System.out.println("Check not found");
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
    public LinkedList<Check> findAll() {
        ResultSet resultSet = null;
        List<Check> ll = new LinkedList<Check>();
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM checks";
            statement = connection.prepareStatement(queryString);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int createdBy = resultSet.getInt("createdBy");
                float amount = resultSet.getFloat("amount");
                boolean active = resultSet.getBoolean("active");
                System.out.println("ID: " + id
                        + ", createdBy: " + createdBy
                        + ", amount: " + amount
                        + ", active: " + Boolean.toString(active));
                Check check = new Check(id, createdBy, amount, active);
                ll.add(check);
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
        return (LinkedList<Check>) ll;
    }

    public LinkedList<Check> findChecksByCreatedBy(int createdBy) {
        ResultSet resultSet = null;
        List<Check> ll = new LinkedList<Check>();
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM checks WHERE createdBy=? and active=True";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, createdBy);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                float amount = resultSet.getFloat("amount");
                boolean active = resultSet.getBoolean("active");
                System.out.println("ID: " + id
                        + ", createdBy: " + createdBy
                        + ", amount: " + amount
                        + ", active: " + Boolean.toString(active));
                Check check = new Check(id, createdBy, amount, active);
                ll.add(check);
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
        return (LinkedList<Check>) ll;
    }

    @Override
    public void update(Check entity) {
        try {
            connection = getConnection();
            String queryString = "UPDATE Checks SET createdBy=?, amount=?, active=? WHERE Id = ?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, entity.getCreatedBy());
            statement.setFloat(2, entity.getAmount());
            statement.setBoolean(3, entity.getActive());
            statement.setInt(4, entity.getId());
            statement.executeUpdate();
            System.out.println("Check updated successfully!");
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
            String queryString = "DELETE FROM Checks WHERE id=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Check deleted successfully!");
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
