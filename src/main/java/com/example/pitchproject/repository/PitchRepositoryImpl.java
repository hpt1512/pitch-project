package com.example.pitchproject.repository;

import com.example.pitchproject.bean.Pitch;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PitchRepositoryImpl implements IBaseRepository<Pitch> {
    private static final String SELECT_ALL_PITCH = "select * from pitch order by `name`;";
    private static final String SELECT_PITCH_BY_ID = "select * from pitch where id = ?;";

    @Override
    public List<Pitch> findAll() {
        List<Pitch> pitchs = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PITCH);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int idCompany = rs.getInt("id_company");
                String name = rs.getString("name");
                int peopleMax = rs.getInt("people_max");
                Time time = rs.getTime("time");
                int price = rs.getInt("price");
                int status = rs.getInt("status");

                pitchs.add(new Pitch(id, idCompany, name, peopleMax, time, price, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return pitchs;
    }

    @Override
    public void insert(Pitch pitch) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Pitch pitch) throws SQLException {
        return false;
    }

    @Override
    public Pitch getById(int id) {
        Pitch pitch = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PITCH_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int idCompany = rs.getInt("id_company");
                String name = rs.getString("name");
                int peopleMax = rs.getInt("people_max");
                Time time = rs.getTime("time");
                int price = rs.getInt("price");
                int status = rs.getInt("status");

                pitch = new Pitch(id, idCompany, name, peopleMax, time, price, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return pitch;
    }

    @Override
    public List<Pitch> findByName(String name) {
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
