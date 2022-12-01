package com.example.pitchproject.repository;

import com.example.pitchproject.bean.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IBaseRepository<User> {
    private static final String SELECT_ALL_USER = "select * from `user`;";
    private static final String INSERT_USER = "insert into `user` (username, `password`, id_role, full_name, image, phone_number, email, address)\n" +
            "\tvalues  (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_USER = "update `user` set username = ?, `password` = ?, id_role = ?, full_name = ?, image = ?, phone_number = ?, email = ?, address = ?, `point` = ?\n" +
            "where id = ?;";
    private static final String DELETE_USER = "delete from `user` where id = ?;";
    private static final String SELECT_USER_BY_ID = "select * from `user` where id = ?;";
    private static final String SELECT_USER_BY_NAME = "select * from `user`\n" +
            "where full_name like concat('%', ?, '%');";
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int idRole = rs.getInt("id_role");
                String fullName = rs.getString("full_name");
                String image = rs.getString("image");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int point = rs.getInt("point");

                users.add(new User(id, username, password, idRole, fullName, image, phoneNumber, email, address, point));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public void insert(User user) throws SQLException {
        System.out.println(INSERT_USER);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getIdRole());
            preparedStatement.setString(4, user.getFullName());
            preparedStatement.setString(5, user.getImage());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getAddress());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_USER);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean update(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getIdRole());
            preparedStatement.setString(4, user.getFullName());
            preparedStatement.setString(5, user.getImage());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setInt(9, user.getPoint());
            preparedStatement.setInt(10, user.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public User getById(int id) {
        User user = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                int idRole = rs.getInt("id_role");
                String fullName = rs.getString("full_name");
                String image = rs.getString("image");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int point = rs.getInt("point");

                user = new User(id, username, password, idRole, fullName, image, phoneNumber, email, address, point);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> users = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnectDB();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int idRole = rs.getInt("id_role");
                String name2 = rs.getString("full_name");
                String image = rs.getString("image");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int point = rs.getInt("point");

                users.add(new User(id, username, password, idRole, name2, image, phoneNumber, email, address, point));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
