package com.example.pitchproject.repository;

import com.example.pitchproject.bean.Location;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocationRepositoryImpl implements IBaseRepository<Location> {
    private static final String SELECT_ALL_LOCATION = "select * from location;";
    @Override
    public List<Location> findAll() {
        List<Location> locations = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOCATION);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                locations.add(new Location(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return locations;
    }

    @Override
    public void insert(Location location) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Location location) throws SQLException {
        return false;
    }

    @Override
    public Location getById(int id) {
        return null;
    }

    @Override
    public List<Location> findByName(String name) {
        return null;
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
