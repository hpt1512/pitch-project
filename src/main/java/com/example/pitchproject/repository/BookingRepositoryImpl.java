package com.example.pitchproject.repository;

import com.example.pitchproject.bean.Booking;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BookingRepositoryImpl implements IBaseRepository<Booking> {
    private static final String SELECT_ALL_BOOKING = "select * from booking;";
    private static final String INSERT_BOOKING = "insert into booking (id_pitch, id_user, `date`, price, `description`, id_voucher)\n" +
            "\tvalues  (?, ?, ?, ?, ?, ?);";
    @Override
    public List<Booking> findAll() {
        List<Booking> bookings = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKING);) {
            System.out.println(preparedStatement);
            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int idPitch = rs.getInt("id_pitch");
                int idUser = rs.getInt("id_user");
                Date date = rs.getDate("date");
                int price = rs.getInt("price");
                String description = rs.getString("description");
                int idVoucher = rs.getInt("id_voucher");
                int status = rs.getInt("status");

                bookings.add(new Booking(id, idPitch, idUser, date, price, description, idVoucher, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bookings;
    }

    @Override
    public void insert(Booking booking) throws SQLException {
        System.out.println(INSERT_BOOKING);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING)) {
            preparedStatement.setInt(1, booking.getIdPitch());
            preparedStatement.setInt(2, booking.getIdUser());

            java.sql.Date sqlDate = new java.sql.Date(booking.getDate().getTime());
            preparedStatement.setDate(3, sqlDate);

            preparedStatement.setInt(4, booking.getPrice());
            preparedStatement.setString(5, booking.getDescription());
            preparedStatement.setInt(6, booking.getIdVoucher());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Booking booking) throws SQLException {
        return false;
    }

    @Override
    public Booking getById(int id) {
        return null;
    }

    @Override
    public List<Booking> findByName(String name) {
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
