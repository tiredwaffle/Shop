package com.edu.dao.impl;

import com.edu.connection.ConnectionFactory;
import com.edu.dao.EmployeeDao;
import com.edu.entities.CheckItem;
import com.edu.entities.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {

    private Connection connection;
    private PreparedStatement statement;

    public EmployeeDaoImpl(Connection connection) {
        this.statement = null;
        this.connection = connection;
    }

    @Override
    public void create(Employee entity) {
        try {
            connection = getConnection();
            String queryString = "INSERT INTO employees (name, surname, title, level, active) VALUES(?,?,?,?,?)";
            statement = connection.prepareStatement(queryString);
            //statement.setInt(1,entity.getId());
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setString(3, entity.getTitle());
            statement.setInt(4, entity.getLevel());
            statement.setBoolean(5, entity.getActive());
            statement.executeUpdate();
            System.out.println("Employee added successfully");
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
    public Employee findById(int id) {
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM employees WHERE employeeId=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String title = resultSet.getString("title");
                int level = resultSet.getInt("level");
                boolean active = resultSet.getBoolean("active");
                System.out.println("ID: " + id
                        + ", name: " + name
                        + ", surname: " + surname
                        + ", title: " + title
                        + ", level: " + level
                        + ", active: " + Boolean.toString(active));
                return new Employee(id, name, surname, title, level, active);
            } else {
                System.out.println("Employee not found");
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
    public Employee findBySurname(String surname) {
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM employees WHERE surname=?";
            statement = connection.prepareStatement(queryString);
            statement.setString(1, surname);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employeeId"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setTitle(resultSet.getString("title"));
                employee.setLevel(resultSet.getInt("level"));
                employee.setActive(resultSet.getBoolean("active"));
                return employee;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LinkedList<Employee> findAll() {
        ResultSet resultSet = null;
        List<Employee> ll = new LinkedList<Employee>();
        try {
            connection = getConnection();
            String queryString = "SELECT * FROM employees";
            statement = connection.prepareStatement(queryString);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employeeId");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String title = resultSet.getString("title");
                int level = resultSet.getInt("level");
                boolean active = resultSet.getBoolean("active");
                Employee employee = new Employee(id, name, surname, title, level, active);
                ll.add(employee);
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
        return (LinkedList<Employee>) ll;
    }

    @Override
    public void update(Employee entity) {
        try {
            connection = getConnection();
            String queryString = "UPDATE employees SET name=?, surname=?, title=?, level=?, active=? WHERE employeeId = ?";
            statement = connection.prepareStatement(queryString);
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSurname());
            statement.setString(3, entity.getTitle());
            statement.setInt(4, entity.getLevel());
            statement.setBoolean(5, entity.getActive());
            statement.setInt(6,entity.getId());
            statement.executeUpdate();
            System.out.println("Employee updated successfully");
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
    public void fireEmployee(int id) {
        try {
            connection = getConnection();
            String queryString = "UPDATE employees SET active = 0 WHERE id=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Employee fired successfully");
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
    public void promoteEmployee(int id, int level) {
        try {
            connection = getConnection();
            String queryString = "UPDATE employees SET level = ? WHERE id=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, level);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Employee promoted successfully");
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
    public void delete(int id) {
        try {
            connection = getConnection();
            String queryString = "DELETE FROM employees WHERE employeeId=?";
            statement = connection.prepareStatement(queryString);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Employee deleted successfully");
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
