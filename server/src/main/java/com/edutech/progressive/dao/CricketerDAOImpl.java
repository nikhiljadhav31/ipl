package com.edutech.progressive.dao;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Cricketer;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CricketerDAOImpl implements CricketerDAO {

    @Override
    public int addCricketer(Cricketer cricketer) throws SQLException {
        String sql = "INSERT INTO cricketer (team_id, cricketer_name, age, nationality, experience, role, total_runs, total_wickets) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int generatedID = -1;

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, cricketer.getTeamId());
            statement.setString(2, cricketer.getCricketerName());
            statement.setInt(3, cricketer.getAge());
            statement.setString(4, cricketer.getNationality());
            statement.setInt(5, cricketer.getExperience());
            statement.setString(6, cricketer.getRole());
            statement.setInt(7, cricketer.getTotalRuns());
            statement.setInt(8, cricketer.getTotalWickets());

            statement.executeUpdate();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    generatedID = resultSet.getInt(1);
                    cricketer.setCricketerId(generatedID);
                } else {
                    throw new SQLException("Adding cricketer failed, no ID obtained.");
                }
            }
        }

        return generatedID;
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException {
        String sql = "SELECT * FROM cricketer WHERE cricketer_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cricketerId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int teamId = resultSet.getInt("team_id");
                    String cricketerName = resultSet.getString("cricketer_name");
                    int age = resultSet.getInt("age");
                    String nationality = resultSet.getString("nationality");
                    int experience = resultSet.getInt("experience");
                    String role = resultSet.getString("role");
                    int totalRuns = resultSet.getInt("total_runs");
                    int totalWickets = resultSet.getInt("total_wickets");

                    return new Cricketer(
                            cricketerId,
                            teamId,
                            cricketerName,
                            age,
                            nationality,
                            experience,
                            role,
                            totalRuns,
                            totalWickets);
                }
            }
        }

        return null;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException {
        String sql = "UPDATE cricketer SET team_id = ?, cricketer_name = ?, age = ?, nationality = ?, " +
                "experience = ?, role = ?, total_runs = ?, total_wickets = ? WHERE cricketer_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cricketer.getTeamId());
            statement.setString(2, cricketer.getCricketerName());
            statement.setInt(3, cricketer.getAge());
            statement.setString(4, cricketer.getNationality());
            statement.setInt(5, cricketer.getExperience());
            statement.setString(6, cricketer.getRole());
            statement.setInt(7, cricketer.getTotalRuns());
            statement.setInt(8, cricketer.getTotalWickets());
            statement.setInt(9, cricketer.getCricketerId());

            statement.executeUpdate();
        }
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException {
        String sql = "DELETE FROM cricketer WHERE cricketer_id = ?";

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cricketerId);
            statement.executeUpdate();
        }
    }

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
        List<Cricketer> cricketers = new ArrayList<>();
        String sql = "SELECT * FROM cricketer";

        try (Connection connection = DatabaseConnectionManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int cricketerId = resultSet.getInt("cricketer_id");
                int teamId = resultSet.getInt("team_id");
                String cricketerName = resultSet.getString("cricketer_name");
                int age = resultSet.getInt("age");
                String nationality = resultSet.getString("nationality");
                int experience = resultSet.getInt("experience");
                String role = resultSet.getString("role");
                int totalRuns = resultSet.getInt("total_runs");
                int totalWickets = resultSet.getInt("total_wickets");

                cricketers.add(new Cricketer(
                        cricketerId,
                        teamId,
                        cricketerName,
                        age,
                        nationality,
                        experience,
                        role,
                        totalRuns,
                        totalWickets));
            }
        }

        return cricketers;
    }
}