package com.example.pitchproject.repository;


import com.example.pitchproject.bean.Company;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRepositoryImpl implements IBaseRepository<Company> {
    private static final String SELECT_ALL_COMPANY = "select * from company;";
    private static final String SELECT_COMPANY_BY_ID = "select * from company where id = ?;";
    @Override
    public List<Company> findAll() {
        List<Company> companies = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMPANY);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int idLocation = rs.getInt("id_location");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int idUser = rs.getInt("id_user");

                companies.add(new Company(id, idLocation, name, image, phoneNumber, email, address, idUser));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return companies;
    }

    @Override
    public void insert(Company company) throws SQLException {

    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Company company) throws SQLException {
        return false;
    }

    @Override
    public Company getById(int id) {
        Company company = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMPANY_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int idLocation = rs.getInt("id_location");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String phoneNumber = rs.getString("phone_number");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int idUser = rs.getInt("id_user");

                company = new Company(id, idLocation, name, image, phoneNumber, email, address, idUser);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return company;
    }

    @Override
    public List<Company> findByName(String name) {
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
